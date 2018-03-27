package kings_gambit.model;

import kings_gambit.contracts.Observer;

public class Footman extends AbstractUnit implements Observer {
    public Footman(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(String.format("Footman %s is panicking!", super.getName()));
    }
}
