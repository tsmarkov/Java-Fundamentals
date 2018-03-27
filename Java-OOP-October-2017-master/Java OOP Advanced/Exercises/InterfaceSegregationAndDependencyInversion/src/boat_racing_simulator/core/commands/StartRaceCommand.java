package boat_racing_simulator.core.commands;

import boat_racing_simulator.core.BaseCommand;
import boat_racing_simulator.exeptions.InsufficientContestantsException;
import boat_racing_simulator.exeptions.NoSetRaceException;

public class StartRaceCommand extends BaseCommand {
    @Override
    public String execute() throws NoSetRaceException, InsufficientContestantsException {
        return super.getController().startRace();
    }
}
