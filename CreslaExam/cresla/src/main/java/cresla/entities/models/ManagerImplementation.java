package cresla.entities.models;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.modules.AbstractAbsorbingModule;
import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImplementation implements Manager {
    private int id;

    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;

    public ManagerImplementation() {
        this.id = 1;
        this.reactors = new HashMap<>();
        this.modules = new HashMap<>();
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String reactorType = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));

        Container container = new ModuleContainer(moduleCapacity);

        Reactor reactor = null;

        switch (reactorType.toLowerCase()) {
            case "cryo":
                reactor = new CryoReactor(this.id, container, additionalParameter);
                break;
            case "heat":
                reactor = new HeatReactor(this.id, container, additionalParameter);
                break;
        }

        this.reactors.put(id, reactor);

        return String.format("Created %s Reactor - %d", reactorType, id++);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        String moduleType = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));

        Module module = null;

        switch (moduleType.toLowerCase()) {
            case "cryogenrod":
                module = new CryogenRod(this.id, additionalParameter);
                this.reactors.get(reactorId).addEnergyModule((EnergyModule) module);
                break;
            case "heatprocessor":
                module = new HeatProcessor(this.id, additionalParameter);
                this.reactors.get(reactorId).addAbsorbingModule((AbstractAbsorbingModule) module);
                break;
            case "cooldownsystem":
                module = new CooldownSystem(this.id, additionalParameter);
                this.reactors.get(reactorId).addAbsorbingModule((AbstractAbsorbingModule) module);
                break;
        }

        this.modules.put(id, module);

        return String.format("Added %s - %d to Reactor - %d", moduleType, this.id++, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        String report = null;

        int id = Integer.parseInt(arguments.get(0));

        if (this.modules.containsKey(id)) {
            report = this.modules.get(id).toString();
        } else if (this.reactors.containsKey(id)) {
            report = this.reactors.get(id).toString();
        }

        return report;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        int cryoReactorsCount = 0;
        int heatReactorsCount = 0;

        for (Reactor reactor : this.reactors.values()) {
            if (reactor instanceof CryoReactor) {
                cryoReactorsCount++;
            } else if (reactor instanceof HeatReactor) {
                heatReactorsCount++;
            }
        }

        int energyModulesCount = 0;
        int absorbingModulesCount = 0;

        for (Module module : this.modules.values()) {
            if (module instanceof EnergyModule) {
                energyModulesCount++;
            } else if (module instanceof AbstractAbsorbingModule) {
                absorbingModulesCount++;
            }
        }

        long totalEnergyOutput = this.reactors.entrySet().stream().mapToLong(x -> x.getValue().getTotalEnergyOutput()).sum();
        long totalHeatAbsorbingOutput = this.reactors.entrySet().stream().mapToLong(x -> x.getValue().getTotalHeatAbsorbing()).sum();


        return String.format("Cryo Reactors: %d\n", cryoReactorsCount) +
                String.format("Heat Reactors: %d\n", heatReactorsCount) +
                String.format("Energy Modules: %d\n", energyModulesCount) +
                String.format("Absorbing Modules: %d\n", absorbingModulesCount) +
                String.format("Total Energy Output: %d\n", totalEnergyOutput) +
                String.format("Total Heat Absorbing: %d", totalHeatAbsorbingOutput);
    }
}
