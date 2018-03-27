package cresla.entities.modules;

public class HeatProcessor extends AbstractAbsorbingModule {
    public HeatProcessor(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }

    @Override
    public String toString() {
        return String.format("HeatProcessor Module - %d", super.getId())
                + System.lineSeparator()
                + super.toString();
    }
}
