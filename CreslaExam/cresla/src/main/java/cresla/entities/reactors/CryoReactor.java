package cresla.entities.reactors;

import cresla.interfaces.Container;

public class CryoReactor extends AbstractReactor {
    private int cryoProductionIndex;

    public CryoReactor(int id, Container moduleContainer, int cryoProductionIndex) {
        super(id, moduleContainer);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = super.getModuleContainer().getTotalEnergyOutput() * this.cryoProductionIndex;

        if (energyOutput > this.getTotalHeatAbsorbing()) {
            return 0;
        }

        return energyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getModuleContainer().getTotalHeatAbsorbing();
    }

    @Override
    public String toString() {

        return String.format("CryoReactor - %d\n", super.getId()) +
                String.format("Energy Output: %d\n", this.getTotalEnergyOutput()) +
                String.format("Heat Absorbing: %d\n", this.getTotalHeatAbsorbing()) +
                String.format("Modules: %d", super.getModuleCount());

    }
}
