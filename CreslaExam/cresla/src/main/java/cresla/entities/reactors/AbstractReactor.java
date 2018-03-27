package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

import java.lang.reflect.Field;
import java.util.LinkedList;

public abstract class AbstractReactor implements Reactor {
    private int id;
    private Container moduleContainer;

    AbstractReactor(int id, Container moduleContainer) {
        this.id = id;
        this.moduleContainer = moduleContainer;
    }

    Container getModuleContainer() {
        return this.moduleContainer;
    }

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public abstract long getTotalHeatAbsorbing();

    @Override
    @SuppressWarnings("unchecked")
    public int getModuleCount() {
        Class moduleContainer = ModuleContainer.class;
        Field modules = moduleContainer.getDeclaredFields()[1];
        modules.setAccessible(true);

        try {
            return ((LinkedList<ModuleContainer>) modules.get(this.moduleContainer)).size();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
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
