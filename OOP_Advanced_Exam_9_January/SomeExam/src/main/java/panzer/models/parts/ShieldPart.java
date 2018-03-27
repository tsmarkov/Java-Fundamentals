package panzer.models.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShieldPart extends BasePart implements DefenseModifyingPart {
    private int defenseModifier;

    public ShieldPart(String model, double weight, BigDecimal price, int defenceModifier) {
        super(model, weight, price);
        this.defenseModifier = defenceModifier;
    }

    @Override
    public int getDefenseModifier() {
        return this.defenseModifier;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Shield Part - %s", this.getModel())).append(System.lineSeparator());
        sb.append(String.format("Defense %d", this.defenseModifier));

        return sb.toString();
    }
}
