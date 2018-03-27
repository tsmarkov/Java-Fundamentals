import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        if (input[0].isEmpty()) {
            return;
        }

        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        if (numbers.length < 2) {
            print(numbers);
            return;
        }

        boolean hasChanges = false;
        int i1 = 0;
        int i2 = 1;
        while (true) {
            int temp = numbers[i1] | numbers[i2];
            numbers[i1] = numbers[i1] & numbers[i2];

            if (temp != numbers[i2]) {
                hasChanges = true;
            }

            numbers[i2] = temp;

            if (i2 == numbers.length - 1) {
                i1 = -1;
                i2 = 0;

                if (hasChanges) {
                    hasChanges = false;
                } else {
                    break;
                }
            }

            i1++;
            i2++;
        }


        print(numbers);
    }

    private static void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);

            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
