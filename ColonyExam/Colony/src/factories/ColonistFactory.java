package factories;

import entities.colonists.Colonist;
import entities.colonists.engineers.HardwareEngineer;
import entities.colonists.engineers.SoftwareEngineer;
import entities.colonists.medics.GeneralPractitioner;
import entities.colonists.medics.Surgeon;
import entities.colonists.soldiers.Soldier;

public final class ColonistFactory {
    private ColonistFactory() {
    }

    public static SoftwareEngineer createSoftwareEngineer(String id, String familyId, int talent, int age) {
        return new SoftwareEngineer(id, familyId, talent, age);
    }

    public static HardwareEngineer createHardwareEngineer(String id, String familyId, int talent, int age) {
        return new HardwareEngineer(id, familyId, talent, age);
    }

    public static Soldier createSoldier(String id, String familyId, int talent, int age) {
        return new Soldier(id, familyId, talent, age);
    }

    public static GeneralPractitioner createGeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        return new GeneralPractitioner(id, familyId, talent, age, sign);
    }

    public static Surgeon createSurgeon(String id, String familyId, int talent, int age, String sign) {
        return new Surgeon(id, familyId, talent, age, sign);
    }
}
