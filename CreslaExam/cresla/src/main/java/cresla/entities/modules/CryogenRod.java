package cresla.entities.modules;

public class CryogenRod extends AbstractEnergyModule  {
    public CryogenRod(int id, int energyOutput) {
        super(id, energyOutput);
    }

    @Override
    public String toString() {
        return String.format("CryogenRod Module - %d", super.getId())
                + System.lineSeparator()
                + String.format("Energy Output: %d", super.getEnergyOutput());
    }
}
