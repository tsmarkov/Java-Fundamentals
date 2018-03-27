package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.entities.io.InputReaderImplementation;
import cresla.entities.io.OutputWriterImplementation;
import cresla.entities.models.ManagerImplementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReaderImplementation();
        OutputWriter writer = new OutputWriterImplementation();

        Manager manager = new ManagerImplementation();

        whileLoop:
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            List<String> arguments = Arrays.asList(input).subList(1, input.length);

            String output = "";

            switch (input[0].toLowerCase()) {
                case "reactor":
                    output = manager.reactorCommand(arguments);
                    break;
                case "module":
                    output = manager.moduleCommand(arguments);
                    break;
                case "report":
                    output = manager.reportCommand(arguments);
                    break;
                case "exit":
                    output = manager.exitCommand(arguments);
                    writer.writeLine(output);
                    break whileLoop;
                default:
                    break;
            }

            writer.writeLine(output);
        }
    }
}
