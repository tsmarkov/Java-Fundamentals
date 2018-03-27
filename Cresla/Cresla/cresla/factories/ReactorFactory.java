package cresla.factories;

import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.Container;

public class ReactorFactory {
    public static CryoReactor createCryoReactor(int id, int cryoProductionIndex, Container container) {
        return new CryoReactor(id, cryoProductionIndex, container);
    }

    public static HeatReactor createHeatReactor(int id, int heatReductionIndex, Container container) {
        return new HeatReactor(id, heatReductionIndex, container);
    }
}
