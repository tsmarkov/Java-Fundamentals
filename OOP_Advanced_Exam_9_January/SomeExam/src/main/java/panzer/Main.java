package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.engine.Engine;
import panzer.io.InputReaderImpl;
import panzer.io.OutputWriterImpl;
import panzer.manager.ManagerImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, IOException {

            InputReader reader = new InputReaderImpl();
            OutputWriter writer = new OutputWriterImpl();
            Manager manager = new ManagerImpl();

            Engine engine = new Engine(reader, writer, manager);
            engine.run();
    }
}
