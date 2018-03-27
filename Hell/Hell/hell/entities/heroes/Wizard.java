package hell.entities.heroes;

import hell.entities.miscellaneous.constants.Constants;
import hell.interfaces.Inventory;

public class Wizard extends BaseHero {
    public Wizard(String name) {
        super(name, Constants.WIZARD_INITIAL_STRENGTH_VALUE, Constants.WIZARD_INITIAL_AGILITY_VALUE,
                Constants.WIZARD_INITIAL_INTELLIGENCE_VALUE, Constants.WIZARD_INITIAL_HITPOINTS_VALUE,
                Constants.WIZARD_INITIAL_DAMAGE_VALUE);
    }
}
