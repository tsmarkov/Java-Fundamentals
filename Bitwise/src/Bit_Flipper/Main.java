package Bit_Flipper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger seven = new BigInteger("7");
        BigInteger zero = new BigInteger("0");
        BigInteger number = new BigInteger(reader.readLine());

        for (int i = 0; i < 62; i++) {
            BigInteger threeNumbers = number.shiftRight(61 - i).and(new BigInteger("7"));

            if (threeNumbers.equals(seven) || threeNumbers.equals(zero)) {
                number = number.xor(seven.shiftLeft(61 - i));
                i += 2;
            }
        }

        System.out.println(number);
    }
}
