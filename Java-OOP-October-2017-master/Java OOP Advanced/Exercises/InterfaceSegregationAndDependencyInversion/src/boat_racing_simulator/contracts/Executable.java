package boat_racing_simulator.contracts;

import boat_racing_simulator.exeptions.*;

public interface Executable {

    String execute() throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
