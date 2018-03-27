package boat_racing_simulator2.models.boat_engines;

public class JetEngine extends BaseBoatEngine {

    private static final int JET_MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    protected int getMultiplier() {
        return JET_MULTIPLIER;
    }

}
