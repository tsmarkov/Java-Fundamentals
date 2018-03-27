package Bits_Exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(reader.readLine());

        long rightBits = (n >> 3) & 7;
        long leftBits = (n >> 24) & 7;

        long rightMask = ~(7 << 3);
        long leftMask = ~(7 << 24);

        n = n & rightMask;
        n = n & leftMask;

        n = n | (rightBits << 24);
        n = n | (leftBits << 3);

        System.out.println(n);
    }
}
