package cresla.entities.modules.energyModules;

import cresla.entities.modules.ModuleImplementation;
import cresla.interfaces.EnergyModule;

public abstract class EnergyModuleImpl extends ModuleImplementation implements EnergyModule{
    private int energyOutput;

    protected EnergyModuleImpl(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
}
