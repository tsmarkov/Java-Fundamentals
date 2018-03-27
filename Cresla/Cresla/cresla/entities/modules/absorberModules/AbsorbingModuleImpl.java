package cresla.entities.modules.absorberModules;

import cresla.entities.modules.ModuleImplementation;
import cresla.interfaces.AbsorbingModule;

public abstract class AbsorbingModuleImpl extends ModuleImplementation implements AbsorbingModule {
    private int heatAbsorbing;

    protected AbsorbingModuleImpl(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
}
