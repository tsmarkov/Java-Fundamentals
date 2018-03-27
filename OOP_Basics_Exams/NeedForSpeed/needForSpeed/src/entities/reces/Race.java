package entities.reces;

import entities.cars.Car;

import java.util.ArrayList;
import java.util.List;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool, List<Car> participants) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{route} - {length}").append(System.lineSeparator());

        int c = 1;
        for (Car participant : participants) {
            sb.append("%d. {brand} {model} {performancePoints}PP - ${moneyWon}");

            if (c == 3) {
                break;
            }

            if (c != this.participants.size() - 1) {
                sb.append(System.lineSeparator());
            }

            c++;
        }

        return sb.toString();
    }
}
