package cresla.entities.models;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.modules.CryogenRod;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<Integer, Reactor> reactors = new HashMap<>();
    private Map<Integer, Module> modules = new HashMap<>();
    private int id = 1;

    @Override
    public String reactorCommand(List<String> arguments) {
        String type = arguments.get(1);
        int moduleCapacity = Integer.valueOf(arguments.get(3));
        Container container = new ModuleContainer(moduleCapacity);
        int parameter = Integer.valueOf(arguments.get(2));
        if("cryo".equalsIgnoreCase(type)) {
            this.reactors.put(id, new CryoReactor(container, parameter, this.id));
        } else {
            this.reactors.put(id, new HeatReactor(container, parameter, this.id));
        }
        return  "Created " + type + " Reactor - " + this.id++;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        String type = arguments.get(2);
        int reactorId = Integer.valueOf(arguments.get(1));
        int moduleParameter = Integer.valueOf(arguments.get(3));
        if("CryogenRod".equalsIgnoreCase(type)) {
            EnergyModule module = new CryogenRod(id, moduleParameter);
            reactors.get(reactorId).addEnergyModule(module);
            modules.put(id, module);
        } else if ("HeatProcessor".equalsIgnoreCase(type)){
            AbsorbingModule module = new HeatProcessor(id, moduleParameter);
            reactors.get(reactorId).addAbsorbingModule(module);
            modules.put(id, module);
        } else {
            AbsorbingModule module = new CooldownSystem(id, moduleParameter);
            reactors.get(reactorId).addAbsorbingModule(module);
            modules.put(id, module);
        }
        return "Added " + type + " - " + id++ + " to Reactor - " + reactorId;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.valueOf(arguments.get(1));
        if (reactors.containsKey(id)) {
            return reactors.get(id).toString();
        } else {
            return modules.get(id).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long totalEnergyOutput = reactors.entrySet().stream()
                .mapToLong(r-> r.getValue().getTotalEnergyOutput()).sum();
        long totalHeatAbsorbing = reactors.entrySet().stream()
                .mapToLong(r-> r.getValue().getTotalHeatAbsorbing()).sum();
        long cryoReactorCount = this.reactors.entrySet().stream()
                .filter(r -> r.getValue().getClass().getSimpleName().startsWith("Cryo")).count();
        long heatReactorCount = this.reactors.entrySet().stream()
                .filter(r -> r.getValue().getClass().getSimpleName().startsWith("Heat")).count();
        long energyModulesCount = this.modules.entrySet().stream()
                .filter(r -> r.getValue().getClass().getSimpleName().startsWith("Cryogen")).count();
        long absorbingModulesCount = this.modules.entrySet().stream()
                .filter(r -> !r.getValue().getClass().getSimpleName().startsWith("Cryogen")).count();
        return "Cryo Reactors: " + cryoReactorCount + "\n" +
                "Heat Reactors: " + heatReactorCount + "\n" +
                "Energy Modules: " + energyModulesCount + "\n" +
                "Absorbing Modules: " + absorbingModulesCount + "\n" +
                "Total Energy Output: " + totalEnergyOutput + "\n" +
                "Total Heat Absorbing: " + totalHeatAbsorbing;
    }
}
