package kings_gambit.model;

import kings_gambit.contracts.Observer;

public class AbstractUnit {

    private String name;

    protected AbstractUnit(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }
}
