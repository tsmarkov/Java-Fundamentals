package boat_racing_simulator2.models.boat_engines;

public class SterndriveEngine extends BaseBoatEngine {

    private static final int STERNDRIVE_MULTIPLIER = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    protected int getMultiplier() {
        return STERNDRIVE_MULTIPLIER;
    }

}
