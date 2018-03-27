package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;

import java.lang.reflect.Field;
import java.util.List;

public abstract class ReactorImplementation implements Reactor {
    private int id;
    private Container moduleContainer;

    protected ReactorImplementation(int id, Container container) {
        this.id = id;
        this.moduleContainer = container;
    }

    protected Container getModuleContainer() {
        return this.moduleContainer;
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = this.moduleContainer.getTotalEnergyOutput();

        if (energyOutput > this.getTotalHeatAbsorbing()) {
            return 0;
        }

        return energyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.moduleContainer.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() throws NoSuchFieldException, IllegalAccessException {
        Class<ModuleContainer> cl = ModuleContainer.class;
        Field field = cl.getDeclaredField("modulesByInput");
        field.setAccessible(true);

        List<Module> modulesByInput = (List<Module>) field.get(this.moduleContainer);

        return modulesByInput.size();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }
}
