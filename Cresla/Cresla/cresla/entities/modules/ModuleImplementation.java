package cresla.entities.modules;

import cresla.interfaces.Module;

public abstract class ModuleImplementation implements Module {
    private int id;

    protected ModuleImplementation(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
