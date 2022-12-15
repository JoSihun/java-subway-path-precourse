package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainController {
    private final Scanner scanner;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public MainController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

    }

}
