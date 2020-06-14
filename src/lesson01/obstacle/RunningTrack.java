package lesson01.obstacle;

import lesson01.competitor.Competitor;

public class RunningTrack implements Obstacle{
    int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(distance);

    }
}
