package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.service.MainService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainController {
    private final Scanner scanner;
    private static final MainService mainService = new MainService();
    private final LineRepository lineRepository = new LineRepository();
    private static final StationRepository stationRepository = new StationRepository();

    public MainController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        initRoutine();
    }

    private void initRoutine() {
        mainService.initLineInformation();
        mainService.initStationInformation();
        mainService.initDijkstraGraph();
    }
    private void mainRoutine() {
        String mainFunction = mainService.askMainFunction(scanner);
        String pathStandard = mainService.askPathStandard(scanner);
    }
}
