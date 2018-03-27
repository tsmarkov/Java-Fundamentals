package ModifyBitAtGivenPosition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int p = Integer.parseInt(reader.readLine());
        int v = Integer.parseInt(reader.readLine());

        int mask;
        int result;

        if (v == 1) {
            mask = 1 << p;
            result = n | mask;
        } else if (v == 0) {
            mask = ~(1 << p);
            result = n & mask;
        } else {
            System.out.println("Invalid input bit value.");
            return;
        }

        System.out.println(result);
    }
}
