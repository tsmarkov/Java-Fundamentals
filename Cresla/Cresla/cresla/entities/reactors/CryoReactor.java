package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.Container;

public class CryoReactor extends ReactorImplementation {
    private int cryoProductionIndex;

    public CryoReactor(int id, int cryoProductionIndex, Container container) {
        super(id, container);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = super.getModuleContainer().getTotalEnergyOutput() * this.cryoProductionIndex;

        if (energyOutput > super.getTotalHeatAbsorbing()) {
            return 0;
        }

        return energyOutput;
    }
}
