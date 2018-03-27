

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import panzer.contracts.Assembler;
import panzer.models.miscellaneous.VehicleAssembler;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShieldPart;

import java.math.BigDecimal;

public class VehicleAssemblerTest {
    private Assembler assembler;

    @Before
    public void setAssembler() {
        this.assembler = new VehicleAssembler();
    }

    @Test
    public void addTwoArsenalParts() {
        ArsenalPart arsenalPart = new ArsenalPart("name", 0.0, new BigDecimal("0"), 10);
        ArsenalPart arsenalPart1 = new ArsenalPart("name1", 0.0, new BigDecimal("0"), 10);

        this.assembler.addArsenalPart(arsenalPart);
        this.assembler.addArsenalPart(arsenalPart1);

        Assert.assertEquals(20L, this.assembler.getTotalAttackModification());
    }

    @Test
    public void addShieldParts() {
        ShieldPart shield = new ShieldPart("name", 18150.0, new BigDecimal("1"), 100);

        this.assembler.addShellPart(shield);

        Assert.assertEquals(100L, this.assembler.getTotalDefenseModification());
    }

    @Test
    public void adEnduranceParts() {
        EndurancePart shield = new EndurancePart("name", 18150.0, new BigDecimal("1"), 100);

        this.assembler.addEndurancePart(shield);

        Assert.assertEquals(100L, this.assembler.getTotalHitPointModification());
    }
}
