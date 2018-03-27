package boat_racing_simulator2.contracts;

import boat_racing_simulator2.exceptions.DuplicateModelException;
import boat_racing_simulator2.exceptions.InsufficientContestantsException;
import boat_racing_simulator2.exceptions.NoSetRaceException;
import boat_racing_simulator2.exceptions.NonExistantModelException;
import boat_racing_simulator2.exceptions.RaceAlreadyExistsException;

public interface CommandHandler {

    String executeCommand(String[] parameters)
            throws DuplicateModelException,
            NonExistantModelException,
            RaceAlreadyExistsException,
            NoSetRaceException,
            InsufficientContestantsException;

}
