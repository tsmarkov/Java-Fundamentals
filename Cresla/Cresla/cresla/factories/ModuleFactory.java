package cresla.factories;

import cresla.entities.modules.absorberModules.CooldownSystem;
import cresla.entities.modules.absorberModules.HeatProcessor;
import cresla.entities.modules.energyModules.CryogenRod;

public class ModuleFactory {
    public static CooldownSystem createCooldownSystem(int id, int heatAbsorbing) {
        return new CooldownSystem(id, heatAbsorbing);
    }

    public static HeatProcessor createHeatProcessor(int id, int heatAbsorbing) {
        return new HeatProcessor(id, heatAbsorbing);
    }

    public static CryogenRod createCryogenRod(int id, int energyOutput) {
        return new CryogenRod(id, energyOutput);
    }
}
