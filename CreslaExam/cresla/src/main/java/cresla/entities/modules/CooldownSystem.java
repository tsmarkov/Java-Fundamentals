package cresla.entities.modules;

public class CooldownSystem extends AbstractAbsorbingModule  {
    public CooldownSystem(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }

    @Override
    public String toString() {
        return String.format("CooldownSystem Module - %d", super.getId())
                + System.lineSeparator()
                + super.toString();
    }
}
