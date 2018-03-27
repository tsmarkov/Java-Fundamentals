package kings_gambit.contracts;

public interface King extends Attackable, Observer {

    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyObservers();
}
