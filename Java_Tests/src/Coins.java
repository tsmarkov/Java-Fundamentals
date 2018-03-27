import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double resto = Integer.parseInt(reader.readLine());
        int cointsCount = 0;

        double sum = 0;
        //for (int i = 2; i >= 0; i--) {
        //    for (double j = 0.50; j >= 0.0; j /= 2.0) {
        //        if (j == 0.25) {
        //            j -= 0.05;
        //        }
        //    }
        //}

        for (int i = 2; i >= 0; i--) {
            if (sum + i < resto) {
                sum += i;
                i++;
                cointsCount++;
            }
        }

        while (sum != resto) {
            for (double i = 0.50; i >= 0; i /= 2) {
                if (i == 0.25) {
                    i -= 0.05;
                }

                if (sum + i < resto) {
                    sum += i;
                    i *= 2;
                    cointsCount++;
                }
            }
        }

        System.out.println(resto);
    }
}
