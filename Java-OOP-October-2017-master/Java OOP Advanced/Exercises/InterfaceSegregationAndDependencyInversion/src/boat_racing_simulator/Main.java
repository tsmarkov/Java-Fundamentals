package boat_racing_simulator;

import boat_racing_simulator.contracts.*;
import boat_racing_simulator.controllers.BoatSimulatorControllerImpl;
import boat_racing_simulator.core.CommandHandlerImpl;
import boat_racing_simulator.database.DatabaseImpl;
import boat_racing_simulator.database.repositories.BoatEngineRepository;
import boat_racing_simulator.database.repositories.BoatRepository;
import boat_racing_simulator.engines.Engine;
import boat_racing_simulator.io.ConsoleInputReader;
import boat_racing_simulator.io.ConsoleOutputWriter;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        CrudRepository<Boat> boatRepository = new BoatRepository();
        CrudRepository<BoatEngine> boatEngineRepository = new BoatEngineRepository();
        Database database = new DatabaseImpl(boatRepository, boatEngineRepository);
        BoatSimulatorController controller = new BoatSimulatorControllerImpl(database);
        CommandHandler commandHandler = new CommandHandlerImpl(controller);
        Engine engine = new Engine(reader, writer, commandHandler);

        engine.run();
    }
}
