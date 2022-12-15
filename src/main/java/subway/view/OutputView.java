package subway.view;

public class OutputView {
    private static final String MAIN_FUNCTION_LIST_INFO_MESSAGE = "## 메인 화면\n" +
            "1. 경로 조회\n" + "Q. 종료\n";
    private static final String PATH_STANDARD_LIST_INFO_MESSAGE = "## 경로 기준\n" +
            "1. 최단 거리\n" + "2. 최소 시간\n" + "B. 돌아가기\n";

    public void printMainFunctionList() {
        System.out.println(MAIN_FUNCTION_LIST_INFO_MESSAGE);
    }

    public void printPathStandardList() {
        System.out.println(PATH_STANDARD_LIST_INFO_MESSAGE);
    }
}
