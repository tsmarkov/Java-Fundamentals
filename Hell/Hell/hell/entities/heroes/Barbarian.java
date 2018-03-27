package hell.entities.heroes;

import hell.entities.miscellaneous.constants.Constants;

public class Barbarian extends BaseHero {
    public Barbarian(String name) {
        super(name, Constants.BARBARIAN_INITIAL_STRENGTH_VALUE, Constants.BARBARIAN_INITIAL_AGILITY_VALUE,
                Constants.BARBARIAN_INITIAL_INTELLIGENCE_VALUE, Constants.BARBARIAN_INITIAL_HITPOINTS_VALUE,
                Constants.BARBARIAN_INITIAL_DAMAGE_VALUE);
    }
}
