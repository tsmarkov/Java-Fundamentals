package hell.entities.items;

import hell.interfaces.Item;

public abstract class BaseItem implements Item {
    private String name;
    private int strengthBonus;
    private int agilityBonus;
    private int intelligenceBonus;
    private int hitPointsBonus;
    private int damageBonus;

    protected BaseItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getStrengthBonus() {
        return 0;
    }

    @Override
    public int getAgilityBonus() {
        return 0;
    }

    @Override
    public int getIntelligenceBonus() {
        return 0;
    }

    @Override
    public int getHitPointsBonus() {
        return 0;
    }

    @Override
    public int getDamageBonus() {
        return 0;
    }
}
