package cresla.entities.reactors;

import cresla.interfaces.Container;

public class HeatReactor extends AbstractReactor {
    private int heatReductionIndex;

    public HeatReactor(Container container, int parameter, int id) {
        super(container, id);
        this.heatReductionIndex = parameter;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getModuleContainer().getTotalEnergyOutput();

        if(result > this.getTotalHeatAbsorbing()) {
            result = 0;
        }
        return result;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getModuleContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
    }

    @Override
    public String toString() {
        return  "HeatReactor - " + super.getId() + "\n" +
                "Energy Output: " + this.getTotalEnergyOutput() + "\n" +
                "Heat Absorbing: " + this.getTotalHeatAbsorbing() + "\n" +
                "Modules: " + this.getModuleCount();
    }
}
