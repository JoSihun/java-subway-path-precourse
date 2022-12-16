package subway.service;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.Validator;

import java.util.Scanner;

public class MainService {
    private static final Validator validator = new Validator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

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
}
