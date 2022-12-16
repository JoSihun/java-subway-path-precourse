package subway.service;

import subway.domain.*;

import java.util.List;

public class PathService {
    private static final List<List<String>> pathInfos = List.of(
            List.of("교대역", "강남역", "2", "3"),
            List.of("강남역", "역삼역", "2", "3"),
            List.of("교대역", "남부터미널역", "3", "2"),
            List.of("남부터미널역", "양재역", "6", "5"),
            List.of("양재역", "매봉역", "1", "1"),
            List.of("강남역", "양재역", "2", "8"),
            List.of("양재역", "양재시민의숲역", "10", "3")
    );

    public void initialize() {
        for (List<String> pathInfo : pathInfos) {
            Station srcStation = new Station(pathInfo.get(0));
            Station dstStation = new Station(pathInfo.get(1));
            int dist = Integer.parseInt(pathInfo.get(2));
            int time = Integer.parseInt(pathInfo.get(3));
            PathRepository.addPath(new Path(srcStation, dstStation, dist, time));
        }
    }

    public int getDistanceBetween(Station srcStation, Station dstStation) {
        return PathRepository.findPathByNames(srcStation, dstStation).getDist();
    }

    public int getTimeBetween(Station srcStation, Station dstStation) {
        return PathRepository.findPathByNames(srcStation, dstStation).getTime();
    }
}
