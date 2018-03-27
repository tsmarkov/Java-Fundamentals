package Extract_Bit_From_Integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int p = Integer.parseInt(reader.readLine());

        int bit = (n >> p) & 1;

        System.out.println(bit);
    }
}
