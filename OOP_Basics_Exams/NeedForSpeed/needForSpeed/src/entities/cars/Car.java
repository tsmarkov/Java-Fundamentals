package entities.cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %d", this.brand, this.model, this.yearOfProduction)).append(System.lineSeparator());
        sb.append(String.format("%d HP, 100 m/h in %d s", this.horsepower, this.acceleration)).append(System.lineSeparator());
        sb.append(String.format("%d Suspension force, %d Durability", this.suspension, this.durability));

        return sb.toString();
    }
}
