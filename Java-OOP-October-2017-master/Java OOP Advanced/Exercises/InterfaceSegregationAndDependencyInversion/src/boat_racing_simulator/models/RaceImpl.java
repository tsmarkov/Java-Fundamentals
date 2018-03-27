package boat_racing_simulator.models;

import boat_racing_simulator.contracts.Boat;
import boat_racing_simulator.contracts.Race;
import boat_racing_simulator.exeptions.DuplicateModelException;
import boat_racing_simulator.utility.Constants;
import boat_racing_simulator.utility.Validator;

import java.util.*;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private Map<String, Boat> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOceanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new LinkedHashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getWindSpeed() {
        return this.windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return this.oceanCurrentSpeed;
    }

    @Override
    public Boolean getAllowsMotorboats() {
        return this.allowsMotorBoats;
    }

    @Override
    public void addParticipant(Boat boat) throws DuplicateModelException {
        if (this.getRegisteredBoats().containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    @Override
    public List<Boat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }

    protected Map<String, Boat> getRegisteredBoats() {
        return Collections.unmodifiableMap(this.registeredBoats);
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    private void setOceanCurrentSpeed(int oceanCurrentSpeed) {
        this.oceanCurrentSpeed = oceanCurrentSpeed;
    }

    private void setAllowsMotorBoats(Boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    private void setDistance(int distance) {
        Validator.ValidatePropertyValue(distance, "Distance");
        this.distance = distance;
    }
}