package subway.view;

import subway.domain.PathRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final List<String> mainFunction = List.of("1", "Q");
    private static final List<String> pathStandard = List.of("1", "2", "B");
    private static final String INVALID_SELECT_MESSAGE = "[ERROR] 잘못된 기능 입력입니다.";
    private static final String NOT_EXIST_SRC_STATION_MESSAGE = "[ERROR] 출발역이 존재하지 않습니다.";
    private static final String NOT_EXIST_DST_STATION_MESSAGE = "[ERROR] 도착역이 존재하지 않습니다.";
    private static final String INVALID_SAME_STATION_MESSAGE = "[ERROR] 출발역과 도착역이 동일합니다.";
    private static final String INVALID_NOT_CONNECTED_STATION_MESSAGE = "[ERROR] 출발역과 도착역이 연결되어 있지 않습니다.";

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

    public void validateExistSrcStation(String srcStation) {
        List<String> stations = new ArrayList<>();
        for (Station station : StationRepository.stations()) {
            stations.add(station.getName());
        }
        if (!stations.contains(srcStation)) {
            throw new IllegalArgumentException(NOT_EXIST_SRC_STATION_MESSAGE);
        }
    }

    public void validateExistDstStation(String dstStation) {
        List<String> stations = new ArrayList<>();
        for (Station station : StationRepository.stations()) {
            stations.add(station.getName());
        }
        if (!stations.contains(dstStation)) {
            throw new IllegalArgumentException(NOT_EXIST_DST_STATION_MESSAGE);
        }
    }

    public void validateSameStation(String stationA, String stationB) {
        if (stationA.equals(stationB)) {
            throw new IllegalArgumentException(INVALID_SAME_STATION_MESSAGE);
        }
    }

    public void validateConnectedStation(String stationA, String stationB) {
        if (PathRepository.findPathByNames(new Station(stationA), new Station(stationB)) == null) {
            throw new IllegalArgumentException(INVALID_NOT_CONNECTED_STATION_MESSAGE);
        }
    }
}
