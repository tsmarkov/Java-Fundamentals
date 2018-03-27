package cresla.factories;

import cresla.entities.containers.ModuleContainer;

public class ModuleContainerFactory {
    public static ModuleContainer createModuleContainer(int moduleCapacity) {
        return new ModuleContainer(moduleCapacity);
    }
}
