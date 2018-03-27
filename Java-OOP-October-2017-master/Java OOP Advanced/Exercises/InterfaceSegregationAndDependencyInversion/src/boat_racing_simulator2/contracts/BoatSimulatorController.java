package boat_racing_simulator2.contracts;

import boat_racing_simulator2.exceptions.DuplicateModelException;
import boat_racing_simulator2.exceptions.InsufficientContestantsException;
import boat_racing_simulator2.exceptions.NoSetRaceException;
import boat_racing_simulator2.exceptions.NonExistantModelException;
import boat_racing_simulator2.exceptions.RaceAlreadyExistsException;

public interface BoatSimulatorController {

    String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException;

    String createRowBoat(String model, int weight, int oars) throws DuplicateModelException;

    String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException;

    String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException;

    String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException;

    String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException;

    String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException;

    String startRace() throws InsufficientContestantsException, NoSetRaceException;

    String getStatistics()throws NoSetRaceException;

}
