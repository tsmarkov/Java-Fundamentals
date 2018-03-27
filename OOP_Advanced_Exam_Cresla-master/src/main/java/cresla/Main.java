package cresla;

import cresla.entities.io.Reader;
import cresla.entities.io.Writer;
import cresla.entities.models.ManagerImpl;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new Reader();
        OutputWriter writer = new Writer();
        Manager manager = new ManagerImpl();

        whileLoop:
        while (true) {
            List<String> input = Arrays.asList(reader.readLine().split("\\s+"));
            String command = input.get(0).toLowerCase();
            switch (command) {
                case "reactor":
                    writer.writeLine(manager.reactorCommand(input));
                    break;
                case "module":
                    writer.writeLine(manager.moduleCommand(input));
                    break;
                case "report":
                    writer.writeLine(manager.reportCommand(input));
                    break;
                default:
                    writer.writeLine(manager.exitCommand(input));
                    break whileLoop;
            }
        }
    }
}
