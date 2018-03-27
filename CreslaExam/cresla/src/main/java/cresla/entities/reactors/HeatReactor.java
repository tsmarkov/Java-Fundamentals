package cresla.entities.reactors;

import cresla.interfaces.Container;

public class HeatReactor extends AbstractReactor {
    private int heatReductionIndex;

    public HeatReactor(int id, Container moduleContainer, int heatReductionIndex) {
        super(id, moduleContainer);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = super.getModuleContainer().getTotalEnergyOutput();

        if (energyOutput > this.getTotalHeatAbsorbing()) {
            return 0;
        }

        return energyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getModuleContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
    }

    @Override
    public String toString() {
        return String.format("HeatReactor - %d\n", super.getId()) +
                String.format("Energy Output: %d\n", this.getTotalEnergyOutput()) +
                String.format("Heat Absorbing: %d\n", this.getTotalHeatAbsorbing()) +
                String.format("Modules: %d", super.getModuleCount());
    }
}
