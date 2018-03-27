package cresla.interfaces;

public interface Reactor extends Identifiable {

    long getTotalEnergyOutput();

    long getTotalHeatAbsorbing();

    int getModuleCount() throws NoSuchFieldException, IllegalAccessException;

    void addEnergyModule(EnergyModule energyModule);

    void addAbsorbingModule(AbsorbingModule absorbingModule);
}
