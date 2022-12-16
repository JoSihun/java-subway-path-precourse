package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    // TODO: 기능 구현
    public static Line getLineByName(String lineName) {
        for (Line line : lines) {
            if (line.getName().equals(lineName)) {
                return line;
            }
        }
        return null;
    }

    public static boolean contains(String lineName) {
        return lines.contains(getLineByName(lineName));
    }
}
