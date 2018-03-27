package kings_gambit.model;

import kings_gambit.contracts.Attackable;
import kings_gambit.contracts.Observer;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractUnit implements kings_gambit.contracts.King {

    private List<Observer> observers;

    public King(String name) {
        super(name);
        this.observers = new ArrayList<>();
    }

    @Override
    public void attack() {
        this.notifyObservers();
    }

    @Override
    public void update() {
        System.out.println(String.format("King %s is under attack!", super.getName()));
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
}
