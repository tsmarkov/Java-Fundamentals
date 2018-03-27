package panzer.manager;

import panzer.contracts.*;
import panzer.core.PanzerBattleOperator;
import panzer.models.miscellaneous.VehicleAssembler;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShieldPart;
import panzer.models.vehicles.BaseVehicle;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ManagerImpl implements Manager {
    private Map<String, Vehicle> undefeatedVehicles;
    private Map<String, Vehicle> defeatedVehicles;
    private Map<String, Part> parts;
    private BattleOperator battleOperator;

    public ManagerImpl() {
        this.undefeatedVehicles = new LinkedHashMap<>();
        this.defeatedVehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
        this.battleOperator = new PanzerBattleOperator();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        String vehicleType = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        long attack = Long.parseLong(arguments.get(5));
        long defense = Long.parseLong(arguments.get(6));
        long hitPoints = Long.parseLong(arguments.get(7));

        Vehicle vehicle = null;
        Assembler assembler = new VehicleAssembler();

        switch (vehicleType) {
            case "Revenger":
                vehicle = new Revenger(model, weight, price, attack, defense, hitPoints, assembler);
                break;
            case "Vanguard":
                vehicle = new Vanguard(model, weight, price, attack, defense, hitPoints, assembler);
                break;
        }

        this.undefeatedVehicles.put(model, vehicle);

        return String.format("Created %s Vehicle - %s", vehicleType, model);
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(1);
        String partType = arguments.get(2);
        String model = arguments.get(3);
        double weight = Double.parseDouble(arguments.get(4));
        BigDecimal price = new BigDecimal(arguments.get(5));
        int additionalParameter = Integer.parseInt(arguments.get(6));

        if (!this.undefeatedVehicles.containsKey(vehicleModel)) {
            return "";
        }

        Part part = null;

        switch (partType) {
            case "Arsenal":
                part = new ArsenalPart(model, weight, price, additionalParameter);
                this.undefeatedVehicles.get(vehicleModel).addArsenalPart(part);
                break;
            case "Shell":
                part = new ShieldPart(model, weight, price, additionalParameter);
                this.undefeatedVehicles.get(vehicleModel).addShellPart(part);
                break;
            case "Endurance":
                part = new EndurancePart(model, weight, price, additionalParameter);
                this.undefeatedVehicles.get(vehicleModel).addEndurancePart(part);
                break;
        }

        this.parts.put(model, part);

        return String.format("Added %s - %s to Vehicle - %s", partType, model, vehicleModel);
    }


    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(1);

        if (this.undefeatedVehicles.containsKey(model)) {
            return this.undefeatedVehicles.get(model).toString();
        } else if (this.parts.containsKey(model)) {
            return this.parts.get(model).toString();
        }

        return "The model doesn't exists! Inspect error.";
    }

    @Override
    public String battle(List<String> arguments) throws IllegalAccessException {
        String vehicleModel1 = arguments.get(1);
        String vehicleModel2 = arguments.get(2);

        if (this.undefeatedVehicles.containsKey(vehicleModel1) && this.undefeatedVehicles.containsKey(vehicleModel2)) {
            String winner = this.battleOperator.battle(this.undefeatedVehicles.get(vehicleModel1), this.undefeatedVehicles.get(vehicleModel2));

            Iterable<Part> parts = null;

            if (winner.equals(vehicleModel1)) {
                this.defeatedVehicles.put(vehicleModel2, this.undefeatedVehicles.remove(vehicleModel2));
                parts = this.defeatedVehicles.get(vehicleModel2).getParts();
            } else {
                this.defeatedVehicles.put(vehicleModel1, this.undefeatedVehicles.remove(vehicleModel1));
                parts = this.defeatedVehicles.get(vehicleModel1).getParts();
            }

            for (Part part : parts) {
                if (this.parts.containsKey(part.getModel())) {
                    this.parts.remove(part.getModel());
                }
            }

            return String.format("%s versus %s -> %s Wins! Flawless Victory!",
                    vehicleModel1, vehicleModel2, winner);
        }

        return "";
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();

        sb.append("Remaining Vehicles: ");
        keys(sb, undefeatedVehicles.keySet());
        sb.append(System.lineSeparator());

        sb.append("Defeated Vehicles: ");
        keys(sb, defeatedVehicles.keySet());
        sb.append(System.lineSeparator());


        sb.append("Currently Used Parts: ").append(this.parts.size());

        return sb.toString();
    }

    private void keys(StringBuilder sb, Set<String> set) {
        if (set.isEmpty()) {
            sb.append("None");
        }

        int i = 0;
        for (String s : set) {
            if (i != 0) {
                sb.append(String.format(", %s", s));
            } else {
                sb.append(s);
            }

            i++;
        }
    }
}
