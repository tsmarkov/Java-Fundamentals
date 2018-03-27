package cresla.entities.reactors;

import cresla.interfaces.Container;

public class CryoReactor extends AbstractReactor {

    private int cryoProductionIndex;

    public CryoReactor(Container container, int parameter, int id) {
        super(container, id);
        this.cryoProductionIndex = parameter;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getModuleContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
        if(result > this.getTotalHeatAbsorbing()) {
            result = 0;
        }
        return result;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getModuleContainer().getTotalHeatAbsorbing();
    }

    @Override
    public String toString() {
        return  "CryoReactor - " + super.getId() + "\n" +
                "Energy Output: " + this.getTotalEnergyOutput() + "\n" +
                "Heat Absorbing: " + this.getTotalHeatAbsorbing() + "\n" +
                "Modules: " + this.getModuleCount();
    }
}
