package boat_racing_simulator2.core;

import boat_racing_simulator2.contracts.CommandHandler;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Engine implements Runnable {

    private BufferedReader reader;
    private CommandHandler commandHandler;

    public Engine(CommandHandler commandHandler) {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.commandHandler = commandHandler;
    }

    @Override
    public void run() {
        StringBuilder output = new StringBuilder();
        while (true) {
            try {
                String input = reader.readLine();
                if ("End".equals(input)) {
                    break;
                }

                String[] arguments = input.split("\\\\");
                String commandResult = this.commandHandler.executeCommand(arguments);
                output.append(commandResult).append(System.lineSeparator());
            } catch (Exception exception) {
                output.append(exception.getMessage()).append(System.lineSeparator());
            }
        }
        if (output.length() > 0) {
            System.out.println(output.toString().trim());
        }
    }

}
