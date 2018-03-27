package boat_racing_simulator.controllers;

import boat_racing_simulator.contracts.*;
import boat_racing_simulator.exeptions.*;
import boat_racing_simulator.factories.BoatEngineFactory;
import boat_racing_simulator.factories.BoatFactory;
import boat_racing_simulator.factories.RaceFactory;
import boat_racing_simulator.utility.Constants;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {
    private static final String[] POSITIONS = {"First", "Second", "Third"};

    private Database database;
    private Race race;

    public BoatSimulatorControllerImpl(Database database) {
        this.database = database;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException {
        BoatEngine engine = null;
        switch (engineType) {
            case "Jet":
                engine = BoatEngineFactory.createJetEngine(model, horsepower, displacement);
                break;
            case "Sterndrive":
                engine = BoatEngineFactory.createSterndriveEngine(model, horsepower, displacement);
                break;
        }

        this.database.getBoatEngineRepository().add(engine);
        return String.format("Engine model %s with %s HP and displacement %s cm3 created successfully.", model, horsepower, displacement);
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = BoatFactory.createRowBoat(model, weight, oars);
        this.database.getBoatRepository().add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = BoatFactory.createSailBoat(model, weight, sailEfficiency);
        this.database.getBoatRepository().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getBoatEngineRepository().getByModel(firstEngineModel);
        BoatEngine secondEngine = this.database.getBoatEngineRepository().getByModel(secondEngineModel);
        Boat boat = BoatFactory.createPowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoatRepository().add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BoatEngine engine = this.database.getBoatEngineRepository().getByModel(engineModel);
        Boat boat = BoatFactory.createYacht(model, weight, engine, cargoWeight);
        this.database.getBoatRepository().add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = RaceFactory.createRace(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.race = race;
        return String.format("A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.", distance, windSpeed, oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoatRepository().getByModel(model);
        this.validateRaceIsSet();
        if (!this.race.getAllowsMotorboats() && boat.hasEngineInBoat()) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }
        this.race.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        if (this.race == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        List<Boat> participants = this.race.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        Comparator<Boat> bySpeedDescending = (b1, b2) -> {
            double s1 = b1.calculateRaceSpeed(this.race);
            double s2 = b2.calculateRaceSpeed(this.race);
            if (s1 < 0 && s2 < 0) {
                return 0;
            }
            return Double.compare(s2, s1);
        };
        List<Boat> winners = participants.stream()
                .sorted(bySpeedDescending)
                .limit(3)
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        int placeCounter = 1;
        for (Boat winner : winners) {
            double speed = winner.calculateRaceSpeed(this.race);
            double time = this.race.getDistance() / speed;
            result.append(placeCounter == 1 ? "First" : placeCounter == 2 ? "Second" : "Third")
                    .append(" place: ").append(winner.getClass().getSimpleName())
                    .append(" place: ").append(winner.getClass().getSimpleName())
                    .append(" Model: ").append(winner.getModel())
                    .append(" Time: ").append(speed <= 0D ? "Did not finish!" : String.format("%.2f sec", time))
                    .append(System.lineSeparator());
            placeCounter++;
        }

        this.race = null;
        return result.toString().trim();
    }

    @Override
    public String getStatistic() throws NoSetRaceException {
        if (this.race == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        List<Boat> participants = this.race.getParticipants();
        Map<String, List<Boat>> participantsByBoatType = participants.stream().collect(Collectors.groupingBy((p) -> p.getClass().getSimpleName()));
        int totalParticipants = participantsByBoatType.values().stream().mapToInt((p) -> p.size()).sum();

        StringBuilder sb = new StringBuilder();
        participantsByBoatType.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach((e) -> {
                    sb.append(String.format("%s -> %.2f", e.getKey(), 100D * e.getValue().size() / totalParticipants));
                    sb.append("%").append(System.lineSeparator());
                });
        return sb.toString().trim();
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.race == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.race != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }
}
