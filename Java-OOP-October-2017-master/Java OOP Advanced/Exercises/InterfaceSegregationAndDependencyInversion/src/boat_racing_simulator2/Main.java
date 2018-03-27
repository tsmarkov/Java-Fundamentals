package boat_racing_simulator2;

import boat_racing_simulator2.contracts.BoatSimulatorController;
import boat_racing_simulator2.contracts.CommandHandler;
import boat_racing_simulator2.controllers.DefaultBoatSimulatorController;
import boat_racing_simulator2.core.DefaultCommandHandler;
import boat_racing_simulator2.core.Engine;
import boat_racing_simulator2.database.BoatSimulatorDatabase;

public class Main {

    public static void main(String[] args) {
        BoatSimulatorDatabase database = new BoatSimulatorDatabase();
        BoatSimulatorController controller = new DefaultBoatSimulatorController(database);
        CommandHandler commandHandler = new DefaultCommandHandler(controller);
        Runnable engine = new Engine(commandHandler);
        engine.run();
    }
    
}
