package boat_racing_simulator.contracts;

import boat_racing_simulator.exeptions.*;

public interface BoatSimulatorController {

    String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException;

    String createRowBoat(String model, int weight, int oars) throws DuplicateModelException;

    String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException;

    String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException;

    String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException;

    String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException;

    String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException;

    String startRace() throws InsufficientContestantsException, NoSetRaceException;

    String getStatistic() throws NoSetRaceException;
}
