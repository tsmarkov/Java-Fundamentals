package panzer.engine;

import panzer.contracts.BattleOperator;
import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.core.PanzerBattleOperator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Engine {
    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    public void run() throws IOException, IllegalAccessException {
        while (true) {
            List<String> commandParams = Arrays.asList(reader.readLine().split("\\s+| "));

            dispatchCommand(commandParams);

            if (commandParams.get(0).equals("Terminate")) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) throws IllegalAccessException {
        String command = commandParams.get(0);

        String output = "";

        switch (command) {
            case "Vehicle":
                output = manager.addVehicle(commandParams);
                break;
            case "Part":
                output = manager.addPart(commandParams);
                break;
            case "Inspect":
                output = manager.inspect(commandParams);
                break;
            case "Battle":
                output = manager.battle(commandParams);
                break;
            case "Terminate":
                output = manager.terminate(commandParams);
                break;
        }

        writer.println(output);
    }
}
