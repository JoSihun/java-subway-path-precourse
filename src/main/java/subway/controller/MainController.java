package subway.controller;

import subway.service.MainService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainController {
    private final Scanner scanner;
    private static final MainService mainService = new MainService();

    public MainController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        initRoutine();

    }

    private void initRoutine() {
        String mainFunction = mainService.askMainFunction(scanner);
        String pathStandard = mainService.askPathStandard(scanner);
    }
}
