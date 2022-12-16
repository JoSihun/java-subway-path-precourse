package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class StationService {
    private static final List<String> stationNames = List.of(
            "교대역", "강남역", "역삼역",
            "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
    );

    public void initialize() {
        for (String stationName : stationNames) {
            StationRepository.addStation(new Station(stationName));
        }
    }
}
