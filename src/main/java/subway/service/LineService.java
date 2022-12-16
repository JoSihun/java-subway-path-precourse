package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.List;

public class LineService {
    private static final List<String> lineNames = List.of("2호선", "3호선", "신분당선");

    public void initialize() {
        for (String lineName : lineNames) {
            LineRepository.addLine(new Line(lineName));
        }
    }
}
