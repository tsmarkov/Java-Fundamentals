package boat_racing_simulator.contracts;

public interface Database {

    CrudRepository<Boat> getBoatRepository();

    CrudRepository<BoatEngine> getBoatEngineRepository();
}
