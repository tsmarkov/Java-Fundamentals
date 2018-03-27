import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bit_Paths {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Read lines count
        int n = Integer.parseInt(reader.readLine());

        //Read, split and save commands
        int[][] commands = new int[n][8];

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

            commands[i] = arr;
        }

        //Start positions init
        int number = 0;
        int sum = 0;

        int[] positions = new int[n];

        for (int i = 0; i < n; i++) {
            positions[i] = commands[i][0];

            number ^= 1 << 3 - positions[i];
            System.out.println(String.format("%4s", Integer.toBinaryString(number)).replaceAll(" ", "0"));
        }

        sum += number;

        //Processing commands and calculate numbers

        for (int col = 1; col < 8; col++) {
            for (int row = 0; row < n; row++) {
                int oldPos = positions[row];
                int newPos = oldPos + commands[row][col];

                if (((number >> 3 - oldPos) & 1) == 1) {
                    number ^= (1 << oldPos);
                }

                number ^= (1 << newPos);

                positions[row] = newPos;
            }

            System.out.println(String.format("%4s", Integer.toBinaryString(number)).replaceAll(" ", "0"));
            sum += number;
        }

        //Printing results
        System.out.println(String.format("%4s", Integer.toBinaryString(sum)).replaceAll(" ", "0"));
        System.out.println(Integer.toHexString(sum));
        System.out.println(sum);
    }
}
