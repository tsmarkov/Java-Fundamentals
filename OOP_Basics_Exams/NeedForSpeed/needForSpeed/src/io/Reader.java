package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Reader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readLine() throws IOException {
        String s = this.reader.readLine();

        return s;
    }
}
