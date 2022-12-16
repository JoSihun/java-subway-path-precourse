package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.Validator;

import java.util.List;
import java.util.Scanner;

public class MainService {
    private static final Validator validator = new Validator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final PathService pathService = new PathService();
    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);

    public void initVertexDijkstraGraph() {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
    }

    public void setEdgeWeightByDistance() {
        for (Path path : PathRepository.paths()) {
            String srcStation = path.getSrcStation().getName();
            String dstStation = path.getDstStation().getName();
            int distance = path.getDist();
            graph.setEdgeWeight(graph.addEdge(srcStation, dstStation), distance);
        }
    }

    public void setEdgeWeightByTime() {
        for (Path path : PathRepository.paths()) {
            String srcStation = path.getSrcStation().getName();
            String dstStation = path.getDstStation().getName();
            int time = path.getTime();
            graph.setEdgeWeight(graph.addEdge(srcStation, dstStation), time);
        }
    }

    public List<String> getDijkstraShortestPath(String srcStation, String dstStation, String standardSelection) {
        if (standardSelection.equals("1")) {
            setEdgeWeightByDistance();
            return (List<String>) dijkstraShortestPath.getPath(srcStation, dstStation).getVertexList();
        }
        setEdgeWeightByTime();
        return (List<String>) dijkstraShortestPath.getPath(srcStation, dstStation).getVertexList();
    }

    public int getDistanceShortestPath(List<String> paths) {
        int distance = 0;
        for (int index = 0; index < paths.size() - 1; index++) {
            Station srcStation = new Station(paths.get(index));
            Station dstStation = new Station(paths.get(index + 1));
            distance += pathService.getDistanceBetween(srcStation, dstStation);
        }
        return distance;
    }

    public int getTimeShortestPath(List<String> paths) {
        int time = 0;
        for (int index = 0; index < paths.size() - 1; index++) {
            Station srcStation = new Station(paths.get(index));
            Station dstStation = new Station(paths.get(index + 1));
            time += pathService.getTimeBetween(srcStation, dstStation);
        }
        return time;
    }

    public String askMainFunction(Scanner scanner) {
        outputView.printMainFunctionList();
        while (true) {
            try {
                String selection = inputView.readFunctionSelection(scanner);
                validator.validateMainFunctionSelection(selection);
                return selection;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String askPathStandard(Scanner scanner) {
        outputView.printPathStandardList();
        while (true) {
            try {
                String selection = inputView.readFunctionSelection(scanner);
                validator.validatePathStandardSelection(selection);
                return selection;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public String askSrcStaion(Scanner scanner) {
        while (true) {
            try {
                String station = inputView.readSrcStation(scanner);
                validator.validateExistSrcStation(station);
                return station;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String askDstStaion(Scanner scanner) {
        while (true) {
            try {
                String station = inputView.readDstStation(scanner);
                validator.validateExistDstStation(station);
                return station;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> askStations(Scanner scanner) {
        while (true) {
            try {
                String srcStation = askSrcStaion(scanner);
                String dstStation = askDstStaion(scanner);
                validator.validateSameStation(srcStation, dstStation);
                validator.validateConnectedStation(srcStation, dstStation);
                return List.of(srcStation, dstStation);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printResult(List<String> paths, int distance, int time) {
        outputView.printResult(paths, distance, time);
    }
}
