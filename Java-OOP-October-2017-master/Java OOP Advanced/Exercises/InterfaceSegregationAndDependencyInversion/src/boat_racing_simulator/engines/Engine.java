package boat_racing_simulator.engines;

import boat_racing_simulator.contracts.CommandHandler;
import boat_racing_simulator.contracts.InputReader;
import boat_racing_simulator.contracts.OutputWriter;
import boat_racing_simulator.contracts.Runnable;
import boat_racing_simulator.exeptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "End";

    private InputReader reader;
    private OutputWriter writer;
    private CommandHandler commandHandler;

    public Engine(InputReader reader, OutputWriter writer, CommandHandler commandHandler) {
        this.reader = reader;
        this.writer = writer;
        this.commandHandler = commandHandler;
    }

    @Override
    public void run() {
        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\\\")));

            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }

            try {
                String result = this.commandHandler.executeCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
                if (result != null) {
                    this.writer.writeLine(result);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalStateException | DuplicateModelException | NonExistantModelException | RaceAlreadyExistsException | NoSetRaceException | InsufficientContestantsException | IllegalArgumentException e) {
                this.writer.writeLine(e.getMessage());
            }
        }
    }
}