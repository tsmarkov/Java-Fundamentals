package factories;

import entities.Colony;

public final class ColonyFactory {
    private ColonyFactory() {
    }

    public static Colony makeColony(int maxFamilyCount, int maxFamilyCapacity) {
        return new Colony(maxFamilyCount, maxFamilyCapacity);
    }
}
