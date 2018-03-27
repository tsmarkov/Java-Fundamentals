package hell.entities.heroes;

import hell.entities.miscellaneous.constants.Constants;
import hell.interfaces.Inventory;

public class Assassin extends BaseHero {
    public Assassin(String name) {
        super(name, Constants.ASSASSIN_INITIAL_STRENGTH_VALUE, Constants.ASSASSIN_INITIAL_AGILITY_VALUE,
                Constants.ASSASSIN_INITIAL_INTELLIGENCE_VALUE, Constants.ASSASSIN_INITIAL_HITPOINTS_VALUE,
                Constants.BARBARIAN_INITIAL_DAMAGE_VALUE);
    }
}
