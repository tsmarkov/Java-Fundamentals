package dependency_inversion.strategies;

import dependency_inversion.contracts.Strategy;

public class AdditionStrategy implements Strategy {

    public int calculate(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
}
