package entities;

import entities.colonists.Colonist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Family {
    private String id;
    private Map<String, List<Colonist>> familyMembers;

    public Family(String id) {
        this.id = id;
        this.familyMembers = new TreeMap<>();
    }


    public String getId() {
        return id;
    }

    public List<Colonist> getFamilyMembers(String familyId) {
        //TODO: Validation
        return this.familyMembers.get(familyId);
    }
}
