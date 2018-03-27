package entities;

import entities.colonists.Colonist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Family {
    private String id;
    private Map<String, Colonist> familyMembers;

    public Family(String id) {
        this.id = id;
        this.familyMembers = new TreeMap<>();
    }


    public String getId() {
        return id;
    }

    public void addFamilyMember(Colonist colonist) {
        this.familyMembers.putIfAbsent(colonist.getId(), colonist);
    }

    public void removeFamilyMember(String id) {
        this.familyMembers.remove(id);
    }

    public int getFamilyMembersCount() {
        return this.familyMembers.size();
    }

    public List<Colonist> getFamilyMembers() {
        List<Colonist> colonists = new ArrayList<>();

        colonists.addAll(familyMembers.values());

        return colonists;
    }

    public void growAll(int years) {
        for (Colonist colonist : familyMembers.values()) {
            colonist.grow(years);
        }
    }

    public int getAllPotential() {
        int potential = 0;
        for (Colonist colonist : familyMembers.values()) {
            potential += colonist.getPotential();
        }

        return potential;
    }
}
