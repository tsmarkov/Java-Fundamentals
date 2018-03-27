package kings_gambit.model;

import kings_gambit.contracts.Observer;

public class RoyalGuard extends AbstractUnit implements Observer {
    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
    }
}
