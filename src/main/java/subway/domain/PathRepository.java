package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    public static List<Path> paths() {
        return Collections.unmodifiableList(paths);
    }

    public static void addPath(Path path) {
        paths.add(path);
    }

    public static boolean deletePath(String srcStationName, String dstStationName) {
        return paths.removeIf(path ->
                Objects.equals(path.getSrcStation().getName(), srcStationName) &&
                        Objects.equals(path.getDstStation().getName(), dstStationName));
    }

    public static void deleteAll() {
        paths.clear();
    }

    // TODO: 기능 구현
    public static Path findPathByNames(Station srcStation, Station dstStation) {
        for (Path path : paths) {
            if ((path.getSrcStation().getName().equals(srcStation.getName()) &&
                    path.getDstStation().getName().equals(dstStation.getName())) ||
                    (path.getSrcStation().getName().equals(dstStation.getName()) &&
                            path.getDstStation().getName().equals(srcStation.getName()))) {
                return path;
            }
        }
        return null;
    }
}
