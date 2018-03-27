package boat_racing_simulator.core.commands;

import boat_racing_simulator.core.BaseCommand;
import boat_racing_simulator.exeptions.DuplicateModelException;
import boat_racing_simulator.exeptions.NonExistantModelException;

public class CreateYachtCommand extends BaseCommand {
    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException {
        return super.getController().createYacht(super.getParams().get(0), Integer.parseInt(super.getParams().get(1)), super.getParams().get(2), Integer.parseInt(super.getParams().get(3)));
    }
}
