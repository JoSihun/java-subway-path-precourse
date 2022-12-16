package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainService {
    private static final Validator validator = new Validator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);

    public void initVertexDijkstraGraph() {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
    }

    public void setEdgeWeightByDistance() {
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 2);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 2);
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 3);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 6);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 2);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 10);
    }

    public void setEdgeWeightByTime() {
        graph.setEdgeWeight(graph.addEdge("교대역", "강남역"), 3);
        graph.setEdgeWeight(graph.addEdge("강남역", "역삼역"), 3);
        graph.setEdgeWeight(graph.addEdge("교대역", "남부터미널역"), 2);
        graph.setEdgeWeight(graph.addEdge("남부터미널역", "양재역"), 5);
        graph.setEdgeWeight(graph.addEdge("양재역", "매봉역"), 1);
        graph.setEdgeWeight(graph.addEdge("강남역", "양재역"), 8);
        graph.setEdgeWeight(graph.addEdge("양재역", "양재시민의숲역"), 3);
    }


    public List<String> getDijkstraShortestPath(String srcStation, String dstStation, String standardSelection) {
        if (standardSelection.equals("1")) {
            setEdgeWeightByDistance();
            return (List<String>) dijkstraShortestPath.getPath(srcStation, dstStation).getVertexList();
        }
        setEdgeWeightByTime();
        return (List<String>) dijkstraShortestPath.getPath(srcStation, dstStation).getVertexList();
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
}
