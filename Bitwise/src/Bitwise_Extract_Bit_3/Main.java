package Bitwise_Extract_Bit_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        int bit = (number >> 3) & 1;

        System.out.println(bit);

        //Pattern
        //System.out.println(String.format("%16s", Integer.toBinaryString()).replace(' ', '0'));
    }
}
