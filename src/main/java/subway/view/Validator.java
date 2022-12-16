package subway.view;

import java.util.List;

public class Validator {
    private static final List<String> mainFunction = List.of("1", "Q");
    private static final List<String> pathStandard = List.of("1", "2", "B");
    private static final String INVALID_SELECT_MESSAGE = "[ERROR] 잘못된 기능 입력입니다.";

    public void validateMainFunctionSelection(String selection) {
        if (!mainFunction.contains(selection)) {
            throw new IllegalArgumentException(INVALID_SELECT_MESSAGE);
        }
    }

    public void validatePathStandardSelection(String selection) {
        if (!pathStandard.contains(selection)) {
            throw new IllegalArgumentException(INVALID_SELECT_MESSAGE);
        }
    }
}
