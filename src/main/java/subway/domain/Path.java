package subway.domain;

public class Path {
    private Station srcStation;
    private Station dstStation;
    private int dist;
    private int time;

    public Path(Station srcStation, Station dstStation, int dist, int time) {
        this.srcStation = srcStation;
        this.dstStation = dstStation;
        this.dist = dist;
        this.time = time;
    }

    public Station getSrcStation() {
        return srcStation;
    }

    public Station getDstStation() {
        return dstStation;
    }

    public int getDist() {
        return dist;
    }

    public int getTime() {
        return time;
    }
}
