package boat_racing_simulator.models.engines;

public class SterndriveEngine extends BaseBoatEngine {
    private static final int MULTIPLIER = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    protected int calculateCachedOutput(int horsepower, int displacement) {
        return (horsepower * MULTIPLIER) + displacement;
    }
}
