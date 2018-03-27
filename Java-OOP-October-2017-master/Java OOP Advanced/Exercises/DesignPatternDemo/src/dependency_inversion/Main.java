package dependency_inversion;

import dependency_inversion.contracts.Calculator;
import dependency_inversion.contracts.Strategy;
import dependency_inversion.models.PrimitiveCalculator;
import dependency_inversion.strategies.AdditionStrategy;
import dependency_inversion.strategies.DivisionStrategy;
import dependency_inversion.strategies.MultiplicationStrategy;
import dependency_inversion.strategies.SubtractionStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Calculator calculator = new PrimitiveCalculator(createStrategy("+"));

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            if ("mode".equalsIgnoreCase(tokens[0])) {
                Strategy strategy = createStrategy(tokens[1]);
                if (strategy != null) {
                    calculator.changeStrategy(strategy);
                }
            } else {
                System.out.println(calculator.performCalculation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
            }
        }
    }

    private static Strategy createStrategy(String sign) {
        switch (sign) {
            case "+":
                return new AdditionStrategy();
            case "-":
                return new SubtractionStrategy();
            case "*":
                return new MultiplicationStrategy();
            case "/":
                return new DivisionStrategy();
        }
        return null;
    }
}
