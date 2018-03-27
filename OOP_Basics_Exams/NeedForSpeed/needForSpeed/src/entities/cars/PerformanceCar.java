package entities.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    protected void setHorsepower(int horsepower) {
        int increasedHorsepower = horsepower + (horsepower / 2);
        super.setHorsepower(increasedHorsepower);
    }

    @Override
    protected void setSuspension(int suspension) {
        int increasedSuspension = suspension + (suspension / 4);
        super.setSuspension(increasedSuspension);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator());

        int i = 0;
        for (String addOn : addOns) {
            sb.append(String.format("Add-ons: %s", addOn));

            if (i < addOns.size() - 1) {
                sb.append(System.lineSeparator());
            }

            i++;
        }

        return sb.toString();
    }
}
