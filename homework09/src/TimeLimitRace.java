import java.util.List;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, List<Car> participants, int goldTime) {
        super(length, route, prizePool, participants);
        this.goldTime = goldTime;
    }

    public int getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    // Переопределите toString, equals и hashCode здесь, если это необходимо
    // Например:
    @Override
    public String toString() {
        return "TimeLimitRace{" +
                "goldTime=" + goldTime +
                ", length=" + getLength() +
                ", route='" + getRoute() + '\'' +
                ", prizePool=" + getPrizePool() +
                ", participants=" + getParticipants() +
                '}';
    }
}
