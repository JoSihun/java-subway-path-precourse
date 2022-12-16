package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.service.LineService;
import subway.service.MainService;
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
        mainService.initVertexDijkstraGraph();
    }

    private void mainRoutine() {
        String pathStandard = mainService.askPathStandard(scanner);
        String srcStation = mainService.askSrcStaion(scanner);
        String dstStation = mainService.askDstStaion(scanner);

        List<String> path = mainService.getDijkstraShortestPath(srcStation, dstStation, pathStandard);
        System.out.println(path + "\n");
    }
}
