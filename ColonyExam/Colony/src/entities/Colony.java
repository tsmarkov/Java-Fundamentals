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
        String id = colonist.getId();
        String familyId = colonist.getFamilyId();

        if (this.families.containsKey(familyId) &&
                this.families.get(familyId).getFamilyMembersCount() >= this.maxFamilyCapacity) {
            System.out.println("family is full");
            return;
        }

        if (this.families.size() >= this.maxFamilyCount && !this.families.containsKey(familyId)) {
            System.out.println("colony is full");
            return;
        }


        if (this.families.containsKey(familyId)) {
            this.families.get(familyId).addFamilyMember(colonist);
        } else {
            Family family = new Family(colonist.getFamilyId());
            family.addFamilyMember(colonist);

            this.families.putIfAbsent(familyId, family);
        }
    }

    public void removeColonist(String familyId, String memberId) {
        if (this.families.containsKey(familyId)) {
            this.families.get(familyId).removeFamilyMember(memberId);

            if (this.families.get(familyId).getFamilyMembersCount() == 0) {
                this.families.remove(familyId);
            }
        }
    }

    public void removeFamily(String id) {
        if (this.families.containsKey(id)) {
            this.families.remove(id);
        }
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        if (!this.families.containsKey(familyId)) {
            return null;
        }

        return this.families.get(familyId).getFamilyMembers();
    }

    public void grow(int years) {
        for (Family family : families.values()) {
            family.growAll(years);
        }
    }

    public int getPotential() {
        int potential = 0;
        for (Family family : families.values()) {
            potential += family.getAllPotential();
        }

        return potential;
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("families: %d/%d", this.families.size(), this.maxFamilyCount)).append(System.lineSeparator());

        for (Family family : families.values()) {
            sb.append(String.format("-%s: %d/%d", family.getId(), family.getFamilyMembersCount(), this.maxFamilyCapacity)).append(System.lineSeparator());
        }

        return sb.toString();
    }

}
