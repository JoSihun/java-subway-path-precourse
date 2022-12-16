package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.service.LineService;
import subway.service.MainService;
import subway.service.PathService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private final Scanner scanner;
    private static final MainService mainService = new MainService();
    private static final LineService lineService = new LineService();
    private static final StationService stationService = new StationService();
    private static final PathService pathService = new PathService();
    private final LineRepository lineRepository = new LineRepository();
    private static final StationRepository stationRepository = new StationRepository();

    public MainController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        initRoutine();

        while (!mainService.askMainFunction(scanner).equals("Q")) {
            mainRoutine();
        }


    }

    private void initRoutine() {
        lineService.initialize();
        stationService.initialize();
        pathService.initialize();
        mainService.initVertexDijkstraGraph();
    }

    private void mainRoutine() {
        String pathStandard = mainService.askPathStandard(scanner);
        List<String> stations = mainService.askStations(scanner);
        String srcStation = stations.get(0);
        String dstStation = stations.get(1);

        List<String> paths = mainService.getDijkstraShortestPath(srcStation, dstStation, pathStandard);
        int distance = mainService.getDistanceShortestPath(paths);
        int time = mainService.getTimeShortestPath(paths);
        mainService.printResult(paths, distance, time);
    }
}
