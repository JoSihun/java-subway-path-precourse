package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_FUNCTION_SELECTION = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_SRC_STATION_MESSAGE = "## 출발역을 입력하세요.";
    private static final String INPUT_DST_STATION_MESSAGE = "## 도착역을 입력하세요.";

    public String readFunctionSelection(Scanner scanner) {
        System.out.println(INPUT_FUNCTION_SELECTION);
        return scanner.nextLine();
    }
    
    public String readSrcStation(Scanner scanner) {
        System.out.println(INPUT_SRC_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public String readDstStation(Scanner scanner) {
        System.out.println(INPUT_SRC_STATION_MESSAGE);
        return scanner.nextLine();
    }
}
