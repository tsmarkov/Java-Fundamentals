import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DharmaSonarFence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> numbers = new ArrayList<>();

        while (true) {
            String input = reader.readLine();

            if (input.equals("Reprogram")) {
                break;
            }

            numbers.add(Long.parseLong(input));
        }

        System.out.println(process(numbers));
    }

    private static String process(List<Long> numbers) {
        StringBuilder sb = new StringBuilder();

        for (Long number : numbers) {
            for (long i = 30; i >= 0; i--) {
                long twoDigits = (number >> i) & 3L;

                if (twoDigits == 3L || twoDigits == 0L) {
                    long mask = 3L << i;
                    number = number ^ mask;

                    i--;
                }
            }

            sb.append(number).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
