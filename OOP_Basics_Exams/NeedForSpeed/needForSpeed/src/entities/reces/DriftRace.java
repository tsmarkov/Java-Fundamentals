package entities.reces;

import entities.cars.Car;

import java.util.List;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool, List<Car> participants) {
        super(length, route, prizePool, participants);
    }
}
