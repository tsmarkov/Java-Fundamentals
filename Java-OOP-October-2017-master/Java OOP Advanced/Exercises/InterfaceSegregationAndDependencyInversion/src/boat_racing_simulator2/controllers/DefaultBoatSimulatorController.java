package boat_racing_simulator2.controllers;

import boat_racing_simulator2.contracts.BoatRace;
import boat_racing_simulator2.contracts.BoatSimulatorController;
import boat_racing_simulator2.database.BoatSimulatorDatabase;
import boat_racing_simulator2.enumeration.EngineType;
import boat_racing_simulator2.exceptions.*;
import boat_racing_simulator2.models.DefaultBoatRace;
import boat_racing_simulator2.models.boat_engines.BaseBoatEngine;
import boat_racing_simulator2.models.boat_engines.JetEngine;
import boat_racing_simulator2.models.boat_engines.SterndriveEngine;
import boat_racing_simulator2.models.boats.*;
import boat_racing_simulator2.utility.Constants;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefaultBoatSimulatorController implements BoatSimulatorController {

    private BoatSimulatorDatabase database;
    private BoatRace currentBoatRace;

    public DefaultBoatSimulatorController(BoatSimulatorDatabase database) {
        this.database = database;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, String engineType)
            throws DuplicateModelException {
        EngineType type = null;
        try {
            type = EngineType.valueOf(engineType.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IncorrectEngineTypeException(Constants.IncorrectEngineTypeMessage);
        }

        BaseBoatEngine engine = null;
        switch (type) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
        }

        this.database.getEngines().add(engine);
        StringBuilder sb = new StringBuilder();
        sb.append("Engine model ").append(model).append(" with ").append(horsepower)
                .append(" HP and displacement ").append(displacement).append(" cm3 created successfully.");
        return sb.toString();
    }

    @Override
    public String createRowBoat(String model, int weight, int oars)
            throws DuplicateModelException {
        BaseBoat boat = new RowBoat(model, weight, oars);
        this.database.getBoats().add(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Row boat with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency)
            throws DuplicateModelException {
        BaseBoat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Sail boat with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel)
            throws NonExistantModelException, DuplicateModelException {
        BaseBoatEngine firstEngine = this.database.getEngines().getItem(firstEngineModel);
        BaseBoatEngine secondEngine = this.database.getEngines().getItem(secondEngineModel);
        BaseBoat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().add(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Power boat with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargo)
            throws NonExistantModelException, DuplicateModelException {
        BaseBoatEngine engine = this.database.getEngines().getItem(engineModel);
        BaseBoat boat = new Yacht(model, weight, engine, cargo);
        this.database.getBoats().add(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Yacht with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats)
            throws RaceAlreadyExistsException {
        if (this.currentBoatRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }

        BoatRace boatRace = new DefaultBoatRace(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.currentBoatRace = boatRace;
        StringBuilder sb = new StringBuilder();
        sb.append("A new race with distance ").append(distance).append(" meters, wind speed ")
                .append(windSpeed).append(" m/s and ocean current speed ").append(oceanCurrentSpeed)
                .append(" m/s has been set.");
        return sb.toString();
    }

    @Override
    public String signUpBoat(String model)
            throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        if (this.currentBoatRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        BaseBoat boat = this.database.getBoats().getItem(model);
        if (!this.currentBoatRace.allowsMotorboats() && boat.hasEngine()) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }

        this.currentBoatRace.addParticipant(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Boat with model ").append(model).append(" has signed up for the current Race.");
        return sb.toString();
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        if (this.currentBoatRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        List<BaseBoat> participants = this.currentBoatRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        Comparator<BaseBoat> bySpeedDescending = (b1, b2) -> {
            double s1 = b1.calculateRaceSpeed(this.currentBoatRace);
            double s2 = b2.calculateRaceSpeed(this.currentBoatRace);
            if (s1 < 0 && s2 < 0) {
                return 0;
            }
            return Double.compare(s2, s1);
        };
        List<BaseBoat> winners = participants.stream()
                .sorted(bySpeedDescending)
                .limit(3)
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        int placeCounter = 1;
        for (BaseBoat winner : winners) {
            double speed = winner.calculateRaceSpeed(this.currentBoatRace);
            double time = this.currentBoatRace.getDistance() / speed;
            result.append(placeCounter == 1 ? "First" : placeCounter == 2 ? "Second" : "Third")
                    .append(" place: ").append(winner.getClass().getSimpleName())
                    .append(" Model: ").append(winner.getModel())
                    .append(" Time: ").append(speed <= 0D ? "Did not finish!" : String.format("%.2f sec", time))
                    .append(System.lineSeparator());
            placeCounter++;
        }

        this.currentBoatRace = null;
        return result.toString().trim();
    }

    @Override
    public String getStatistics() throws NoSetRaceException {
        if (this.currentBoatRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        List<BaseBoat> participants = this.currentBoatRace.getParticipants();
        Map<String, List<BaseBoat>> participantsByBoatType = participants.stream().collect(Collectors.groupingBy((p) -> p.getClass().getSimpleName()));
        int totalParticipants = participantsByBoatType.values().stream().mapToInt((p) -> p.size()).sum();

        StringBuilder sb = new StringBuilder();
        participantsByBoatType.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach((e) -> {
                    sb.append(String.format("%s -> %.2f", e.getKey(), 100D * e.getValue().size() / totalParticipants));
                    sb.append("%").append(System.lineSeparator());
                });
        return sb.toString().trim();
    }

}
