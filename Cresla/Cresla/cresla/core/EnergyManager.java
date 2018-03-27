package cresla.core;

import cresla.entities.modules.energyModules.CryogenRod;
import cresla.entities.modules.energyModules.EnergyModuleImpl;
import cresla.factories.ModuleContainerFactory;
import cresla.factories.ModuleFactory;
import cresla.factories.ReactorFactory;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EnergyManager implements Manager {
    private int id;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public EnergyManager() {
        this.id = 1;
        this.reactors = new LinkedHashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String reactorType = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));
        int moduleCapacity = Integer.parseInt(arguments.get(3));

        Container container = ModuleContainerFactory.createModuleContainer(moduleCapacity);

        Reactor reactor = null;

        switch (reactorType) {
            case "Cryo":
                reactor = ReactorFactory.createCryoReactor(this.id, additionalParameter, container);
                break;
            case "Heat":
                reactor = ReactorFactory.createHeatReactor(this.id, additionalParameter, container);
                break;
        }

        this.reactors.put(this.id, reactor);

        return String.format("Created %s Reactor -%d", reactorType, this.id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {

        int reactorId = Integer.parseInt(arguments.get(1));
        String type = arguments.get(2);
        int additionalParameter = Integer.parseInt(arguments.get(3));

        switch (type) {
            case "CryogenRod":
                CryogenRod cryogenRod = ModuleFactory.createCryogenRod(this.id, additionalParameter);
                this.reactors.get(reactorId).addEnergyModule(cryogenRod);
                this.modules.put(this.id, cryogenRod);
                break;
            case "HeatProcessor":
                AbsorbingModule absorbingModule = ModuleFactory.createHeatProcessor(this.id, additionalParameter);
                this.reactors.get(reactorId).addAbsorbingModule(absorbingModule);
                this.modules.put(this.id, absorbingModule);
                break;
            case "CoolingSystem":
                absorbingModule = ModuleFactory.createHeatProcessor(this.id, additionalParameter);
                this.reactors.get(reactorId).addAbsorbingModule(absorbingModule);
                this.modules.put(this.id, absorbingModule);
                break;
        }

        return String.format("Added %s - %d to Reactor - %d", type, this.id++, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        return null;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        return null;
    }
}
