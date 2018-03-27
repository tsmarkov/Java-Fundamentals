package controllers;

import entities.cars.Car;
import entities.garage.Garage;
import entities.reces.Race;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager {
    private Map<String, Car> cars;
    private Map<String, Garage> garages;
    private Map<String, Race> races;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.garages = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {

    }

    public String check(int id) {
        return null;
    }

    public void open(int id, String type, int length, String route, int prizePool) {
    }

    public void participate(int carId, int raceId) {
    }

    public String start(int id) {
        return null;
    }

    public void park(int id) {
    }

    public void unpark(int id) {
    }

    public void tune(int tuneIndex, String addOn) {
    }
}
