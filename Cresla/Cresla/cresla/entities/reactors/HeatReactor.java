package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.Container;

public class HeatReactor extends ReactorImplementation {
    private int heatReductionIndex;

    public HeatReactor(int id, int heatReductionIndex, Container container) {
        super(id, container);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getModuleContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
    }
}
