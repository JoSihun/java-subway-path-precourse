package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.Validator;

import java.util.Scanner;

public class MainService {
    private static final Validator validator = new Validator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void initLineInformation() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    public void initStationInformation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

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
