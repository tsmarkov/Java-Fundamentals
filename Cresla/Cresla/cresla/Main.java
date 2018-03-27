package cresla;

import cresla.core.EnergyManager;
import cresla.core.Engine;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.InputReaderImpl;
import cresla.io.OutputWriterImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReaderImpl();
        OutputWriter writer = new OutputWriterImpl();
        Manager manager = new EnergyManager();

        Engine engine = new Engine(reader, writer, manager);
        engine.run();
    }
}
