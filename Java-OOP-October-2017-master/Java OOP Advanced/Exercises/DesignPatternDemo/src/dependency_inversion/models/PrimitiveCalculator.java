package dependency_inversion.models;

import dependency_inversion.contracts.Calculator;
import dependency_inversion.contracts.Strategy;
import dependency_inversion.strategies.AdditionStrategy;
import dependency_inversion.strategies.SubtractionStrategy;

public class PrimitiveCalculator implements Calculator {

    private Strategy strategy;

    public PrimitiveCalculator(Strategy strategy){
        this.strategy = strategy;
    }

    @Override
    public void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    @Override
    public int performCalculation(int firstNumber, int secondNumber){
        return this.strategy.calculate(firstNumber, secondNumber);
    }
}
