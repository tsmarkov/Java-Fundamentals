package entities.colonists.medics;

public class Surgeon extends Medic {
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();

        if (super.getAge() > 25 && super.getAge() < 35) {
            potential += 2;
        }

        if (super.getSign().equals("precise")) {
            potential += 3;
        } else if (super.getSign().equals("butcher")) {
            potential -= 3;
        }

        return potential;
    }
}
