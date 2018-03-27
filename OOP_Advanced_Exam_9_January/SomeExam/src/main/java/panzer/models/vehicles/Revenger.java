package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;

import java.math.BigDecimal;
import java.util.List;

public class Revenger extends BaseVehicle {
    public Revenger(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints, Assembler assembler) {
        super(model, weight, price, attack, defense, hitPoints, assembler);
    }

    @Override
    protected void setHitPoints(long hitPoints) {
        super.setHitPoints(hitPoints - (((hitPoints * 50) / 100)));
    }

    @Override
    protected void setAttack(long attack) {
        super.setAttack(attack + ((attack * 150L) / 100L));
    }

    @Override
    protected void setDefense(long defense) {
        super.setDefense(defense - ((defense * 50L) / 100L));
    }

    @Override
    protected void setPrice(BigDecimal price) {
        super.setPrice(price.add((price.multiply(new BigDecimal(50))).divide(new BigDecimal(100))));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Revenger - %s", this.getModel())).append(System.lineSeparator());
        sb.append(String.format("Total Weight: %.3f", this.getTotalWeight())).append(System.lineSeparator());
        sb.append(String.format("Total Price: %.3f", this.getTotalPrice())).append(System.lineSeparator());
        sb.append(String.format("Attack: %d", this.getTotalAttack())).append(System.lineSeparator());
        sb.append(String.format("Defense: %d", this.getTotalDefense())).append(System.lineSeparator());
        sb.append(String.format("HitPoints: %d", this.getTotalHitPoints())).append(System.lineSeparator());
        sb.append("Parts: ");

        List<Part> parts = (List<Part>) this.getParts();

        if (parts.isEmpty()) {
            sb.append("None");
        } else {
            int i = 0;
            for (Part s : parts) {
                if (i != 0) {
                    sb.append(String.format(", %s", s.getModel()));
                } else {
                    sb.append(s.getModel());
                }

                i++;
            }
        }


        return sb.toString();
    }
}
