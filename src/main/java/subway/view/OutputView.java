package subway.view;

import java.util.List;

public class OutputView {
    private static final String MAIN_FUNCTION_LIST_INFO_MESSAGE = "## 메인 화면\n" +
            "1. 경로 조회\n" + "Q. 종료";
    private static final String PATH_STANDARD_LIST_INFO_MESSAGE = "\n## 경로 기준\n" +
            "1. 최단 거리\n" + "2. 최소 시간\n" + "B. 돌아가기";

    public void printMainFunctionList() {
        System.out.println(MAIN_FUNCTION_LIST_INFO_MESSAGE);
    }

    public void printPathStandardList() {
        System.out.println(PATH_STANDARD_LIST_INFO_MESSAGE);
    }

    public void printResult(List<String> path, int distance, int time) {
        System.out.println("\n## 조회 결과");
        System.out.println("[INFO] ---");
        System.out.println("[INFO] 총 거리: " + distance + "km");
        System.out.println("[INFO] 총 소요 시간: " + time + "분");
        System.out.println("[INFO] ---");
        for (String station : path) {
            System.out.println("[INFO] " + station);
        }
        System.out.println();
    }
}
