package Bit_Exchange_Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long number = Long.parseLong(reader.readLine());
        int rightStartPosition = Integer.parseInt(reader.readLine());
        int leftStartPosition = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        //System.out.println(String.format("Num: %32s", Long.toBinaryString(number)).replace(' ', '0'));

        //int leftSequenceLength = (leftStartPosition + k - 1) - leftStartPosition;

        int mask = Integer.parseInt(new String(new char[k]).replace("\0", "1"), 2);

        //System.out.println(String.format("Msk: %32s", Long.toBinaryString(mask)).replace(' ', '0'));

        long rightPart = (number >> rightStartPosition) & mask;
        long leftPart = (number >> leftStartPosition) & mask;

        //System.out.println(String.format("rPt: %32s", Long.toBinaryString(rightPart)).replace(' ', '0'));
        //System.out.println(String.format("lPt: %32s", Long.toBinaryString(leftPart)).replace(' ', '0'));


        number = number & ~(mask << rightStartPosition);
        number = number & ~(mask << leftStartPosition);

        //System.out.println(String.format("za0: %32s", Long.toBinaryString(number)).replace(' ', '0'));

        number = number | (rightPart << leftStartPosition);
        number = number | (leftPart << rightStartPosition);

        System.out.println(number);
        //System.out.println(String.format("Fin: %16s", Long.toBinaryString(number)).replace(' ', '0'));
    }
}
