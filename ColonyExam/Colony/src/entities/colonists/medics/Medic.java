package entities.colonists.medics;

import entities.colonists.Colonist;

public abstract class Medic extends Colonist {
    private String sign;

    Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    @Override
    public int getPotential() {
        return this.getTalent() + 2;
    }
}