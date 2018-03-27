package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends AbstractModule implements EnergyModule {
    private int energyOutput;

    AbstractEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
}
