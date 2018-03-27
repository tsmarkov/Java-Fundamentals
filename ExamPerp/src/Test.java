import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> a = new ArrayDeque<>();
        Collections.addAll(a, 1, 2, 3);


        int b = a.pollFirst();
        for (Integer integer : a) {
            if (integer > b) {
                a.removeFirst();
                System.out.println("polna gi ve" + integer);
            }
        }

        if (a.isEmpty()) {
            System.out.println("Prazno i");
        }
    }
}
