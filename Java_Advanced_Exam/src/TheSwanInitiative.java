import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TheSwanInitiative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] theNumbersInString = reader.readLine().split("[\\s+ ]");
        String[] otherNumbersInString = reader.readLine().split("[\\s+ ]");

        ArrayDeque<Integer> theNumbers = parseNumbersAndAddToDeque(theNumbersInString);
        ArrayDeque<Integer> otherNumbers = parseNumbersAndAddToDeque(otherNumbersInString);

        List<Integer> numbers = processNumbers(theNumbers, otherNumbers);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private static List<Integer> processNumbers(ArrayDeque<Integer> theNumbers, ArrayDeque<Integer> otherNumbers) {
        List<Integer> resultNumbers = new ArrayList<>();

        while (resultNumbers.size() < 6) {
            int number = otherNumbers.pollFirst();

            if (number % theNumbers.peekFirst() == 0) {
                theNumbers.removeFirst();
                resultNumbers.add(number);
            } else {
                otherNumbers.addLast(number + 1);
            }
        }

        return resultNumbers;
    }

    private static ArrayDeque<Integer> parseNumbersAndAddToDeque(String[] numbers) {
        ArrayDeque<Integer> numbersInDeque = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersInDeque.add(Integer.valueOf(numbers[i]));
        }

        return numbersInDeque;
    }
}
