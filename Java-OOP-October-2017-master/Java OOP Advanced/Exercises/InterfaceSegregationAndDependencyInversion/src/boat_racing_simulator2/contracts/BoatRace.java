package boat_racing_simulator2.contracts;

import boat_racing_simulator2.exceptions.DuplicateModelException;
import boat_racing_simulator2.models.boats.BaseBoat;

import java.util.List;

public interface BoatRace {

    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean allowsMotorboats();

    void addParticipant(BaseBoat boat) throws DuplicateModelException;

    List<BaseBoat> getParticipants();

}
