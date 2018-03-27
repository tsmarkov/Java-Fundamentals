package cresla.entities.io;

import cresla.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImplementation implements InputReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }
}
