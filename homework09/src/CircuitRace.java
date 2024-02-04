import java.util.List;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, List<Car> participants, int laps) {
        super(length, route, prizePool, participants);
        this.laps = laps;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    // Переопределение toString, если нужно
    @Override
    public String toString() {
        return "CircuitRace{" +
                "laps=" + laps +
                ", length=" + getLength() +
                ", route='" + getRoute() + '\'' +
                ", prizePool=" + getPrizePool() +
                ", participants=" + getParticipants() +
                '}';
    }

    // Можно также переопределить equals и hashCode, если это необходимо
}
