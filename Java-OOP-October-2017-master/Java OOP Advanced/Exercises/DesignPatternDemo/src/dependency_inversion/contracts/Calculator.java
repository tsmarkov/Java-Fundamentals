package dependency_inversion.contracts;

public interface Calculator {
    void changeStrategy(Strategy strategy);

    int performCalculation(int firstNumber, int secondNumber);
}
