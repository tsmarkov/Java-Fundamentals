package cresla.core;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Engine {
    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager energyManager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = energyManager;
    }

    public void run() throws IOException {

        while (true) {
            List<String> commandParams = Arrays.asList(reader.readLine().split(" "));

            dispatchCommand(commandParams);

            if (commandParams.get(0).equals("Exit")) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.get(0);

        String output = null;

        switch (command) {
            case "Reactor":
                output = this.manager.reactorCommand(commandParams);
                break;
            case "Module":
                output = this.manager.moduleCommand(commandParams);
                break;
            case "Report":
                output = this.manager.reportCommand(commandParams);
                break;
            case "Exit":
                output = this.manager.exitCommand(commandParams);
                break;
        }

        writer.writeLine(output);
    }
}
