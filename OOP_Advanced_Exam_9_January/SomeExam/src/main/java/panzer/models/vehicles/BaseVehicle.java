package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseVehicle implements Vehicle {
    private String model;
    private double weight;
    private BigDecimal price;
    private long attack;
    private long defense;
    private long hitPoints;
    private Assembler assembler;
    private List<Part> byInput;

    protected BaseVehicle(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints, Assembler assembler) {
        this.setModel(model);
        this.setWeight(weight);
        this.setPrice(price);
        this.setAttack(attack);
        this.setDefense(defense);
        this.setHitPoints(hitPoints);
        this.assembler = assembler;
        this.byInput = new ArrayList<>();
    }

    @Override
    public double getTotalWeight() {
        return this.weight + this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price.add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return this.attack + this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return this.defense + this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints + this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
        this.byInput.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
        this.byInput.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addShellPart(endurancePart);
        this.byInput.add(endurancePart);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<Part> getParts() {
        return this.byInput;
    }

    @Override
    public String getModel() {
        return this.model;
    }


    protected void setHitPoints(long hitPoints) {
        this.hitPoints = hitPoints;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setAttack(long attack) {
        this.attack = attack;
    }

    protected void setDefense(long defense) {
        this.defense = defense;
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setModel(String model) {
        this.model = model;
    }
}
