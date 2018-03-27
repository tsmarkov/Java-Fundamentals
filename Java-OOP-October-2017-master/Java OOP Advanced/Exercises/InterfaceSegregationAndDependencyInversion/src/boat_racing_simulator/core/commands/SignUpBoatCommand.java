package boat_racing_simulator.core.commands;

import boat_racing_simulator.core.BaseCommand;
import boat_racing_simulator.exeptions.DuplicateModelException;
import boat_racing_simulator.exeptions.NoSetRaceException;
import boat_racing_simulator.exeptions.NonExistantModelException;

public class SignUpBoatCommand extends BaseCommand {
    @Override
    public String execute() throws NonExistantModelException, NoSetRaceException, DuplicateModelException {
        return super.getController().signUpBoat(super.getParams().get(0));
    }
}
