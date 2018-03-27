package hell.entities.items;

import java.util.Map;

public class RecipeItem extends BaseItem {
    private Map<String, CommonItem> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, Map<String, CommonItem> requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = requiredItems;
    }
}
