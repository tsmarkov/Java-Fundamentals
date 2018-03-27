package entities.colonists.engineers;

import entities.colonists.Colonist;

public abstract class Engineer extends Colonist {
    protected Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public abstract int getPotential();

}
