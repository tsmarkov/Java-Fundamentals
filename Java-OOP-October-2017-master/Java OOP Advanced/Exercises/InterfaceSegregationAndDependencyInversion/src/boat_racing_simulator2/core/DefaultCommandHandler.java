package boat_racing_simulator2.core;

import boat_racing_simulator2.exceptions.DuplicateModelException;
import boat_racing_simulator2.exceptions.InsufficientContestantsException;
import boat_racing_simulator2.exceptions.NoSetRaceException;
import boat_racing_simulator2.exceptions.NonExistantModelException;
import boat_racing_simulator2.exceptions.RaceAlreadyExistsException;

import boat_racing_simulator2.contracts.CommandHandler;
import boat_racing_simulator2.contracts.BoatSimulatorController;

public class DefaultCommandHandler implements CommandHandler {

    public BoatSimulatorController controller;

    public DefaultCommandHandler(BoatSimulatorController controller) {
        this.controller = controller;
    }

    @Override
    public String executeCommand(String[] parameters)
            throws DuplicateModelException,
            NonExistantModelException,
            RaceAlreadyExistsException,
            NoSetRaceException,
            InsufficientContestantsException {
        switch (parameters[0]) {
            case "CreateBoatEngine":
                return this.controller.createBoatEngine(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]),
                        parameters[4]);
            case "CreateRowBoat":
                return this.controller.createRowBoat(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]));
            case "CreateSailBoat":
                return this.controller.createSailBoat(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]));
            case "CreatePowerBoat":
                return this.controller.createPowerBoat(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        parameters[3],
                        parameters[4]);
            case "CreateYacht":
                return this.controller.createYacht(
                        parameters[1],
                        Integer.parseInt(parameters[2]),
                        parameters[3],
                        Integer.parseInt(parameters[4]));
            case "OpenRace":
                return this.controller.openRace(
                        Integer.parseInt(parameters[1]),
                        Integer.parseInt(parameters[2]),
                        Integer.parseInt(parameters[3]),
                        Boolean.parseBoolean(parameters[4]));
            case "SignUpBoat":
                return this.controller.signUpBoat(parameters[1]);
            case "StartRace":
                return this.controller.startRace();
            case "GetStatistic":
                return this.controller.getStatistics();
            default:
                throw new IllegalArgumentException();
        }
    }
}
