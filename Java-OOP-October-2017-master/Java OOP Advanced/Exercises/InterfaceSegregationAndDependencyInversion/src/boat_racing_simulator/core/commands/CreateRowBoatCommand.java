package boat_racing_simulator.core.commands;

import boat_racing_simulator.core.BaseCommand;
import boat_racing_simulator.exeptions.DuplicateModelException;

public class CreateRowBoatCommand extends BaseCommand {
    @Override
    public String execute() throws DuplicateModelException {
        return super.getController().createRowBoat(super.getParams().get(0), Integer.parseInt(super.getParams().get(1)), Integer.parseInt(super.getParams().get(2)));
    }
}
