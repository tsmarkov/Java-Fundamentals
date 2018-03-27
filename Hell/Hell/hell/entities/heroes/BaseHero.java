package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.Collection;

public abstract class BaseHero implements Hero {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public long getStrength() {
        return 0;
    }

    @Override
    public long getAgility() {
        return 0;
    }

    @Override
    public long getIntelligence() {
        return 0;
    }

    @Override
    public long getHitPoints() {
        return 0;
    }

    @Override
    public long getDamage() {
        return 0;
    }

    @Override
    public Collection<Item> getItems() {
        return null;
    }

    @Override
    public void addItem(Item item) {

    }

    @Override
    public void addRecipe(Recipe recipe) {

    }
}
