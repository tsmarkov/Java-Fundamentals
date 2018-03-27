package entities;

import entities.colonists.Colonist;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new TreeMap<>();
    }

    public int getMaxFamilyCount() {
        return maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return maxFamilyCapacity;
    }


    public void addColonist(Colonist colonist) {
    }

    public void removeColonist(String familyId, String memberId) {
    }

    public void removeFamily(String id) {
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        return null;
    }

    public void grow(int years) {
    }

    public int getPotential() {
        return 0;
    }

    public String getCapacity() {
        return null;
    }

}
