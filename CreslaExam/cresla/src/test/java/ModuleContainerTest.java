import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ModuleContainerTest {
    private Container container;
    private AbsorbingModule absorbingModule1;
    private AbsorbingModule absorbingModule2;
    private AbsorbingModule absorbingModule3;
    private AbsorbingModule absorbingModule4;
    private EnergyModule energyModule1;
    private EnergyModule energyModule2;

    @Before
    public void before() {
        int CONTAINER_INITIALIZE_CAPACITY = 3;
        this.container = new ModuleContainer(CONTAINER_INITIALIZE_CAPACITY);
        this.absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModule3 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModule4 = Mockito.mock(AbsorbingModule.class);
        this.energyModule1 = Mockito.mock(EnergyModule.class);
        this.energyModule2 = Mockito.mock(EnergyModule.class);

        Mockito.when(this.absorbingModule1.getId()).thenReturn(1);
        Mockito.when(this.absorbingModule2.getId()).thenReturn(2);
        Mockito.when(this.absorbingModule3.getId()).thenReturn(3);
        Mockito.when(this.absorbingModule4.getId()).thenReturn(4);
        Mockito.when(this.energyModule1.getId()).thenReturn(3);
        Mockito.when(this.energyModule2.getId()).thenReturn(4);

        Mockito.when(this.absorbingModule1.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(this.absorbingModule2.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(this.absorbingModule3.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(this.absorbingModule4.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(this.energyModule1.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(this.energyModule2.getEnergyOutput()).thenReturn(2_000_000_000);
    }

    @Test
    public void addAbsorbingModule() {
        //Act
        this.container.addAbsorbingModule(this.absorbingModule1);
        this.container.addAbsorbingModule(this.absorbingModule2);

        //Assert
        Assert.assertEquals(4_000_000_000L, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void addEnergyModule() {
        //Act
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule2);

        //Assert
        Assert.assertEquals(4_000_000_000L, this.container.getTotalEnergyOutput());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullEnergyModule() {
        //Act
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullAbsorbingModule() {
        //Act
        this.container.addAbsorbingModule(null);
    }

    @Test
    public void removeOldestElement() {
        //Act
        this.container.addEnergyModule(this.energyModule1);
        this.container.addAbsorbingModule(this.absorbingModule1);
        this.container.addAbsorbingModule(this.absorbingModule2);
        this.container.addEnergyModule(this.energyModule1);

        //Assert
        Assert.assertEquals(2_000_000_000, this.container.getTotalEnergyOutput());
        Assert.assertEquals(4_000_000_000L, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void removeOldestElements() {
        //Act
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule1);
        this.container.addAbsorbingModule(this.absorbingModule1);
        this.container.addAbsorbingModule(this.absorbingModule2);
        this.container.addAbsorbingModule(this.absorbingModule3);
        this.container.addAbsorbingModule(this.absorbingModule4);

        //Assert
        Assert.assertEquals(0, this.container.getTotalEnergyOutput());
        Assert.assertEquals(6_000_000_000L, this.container.getTotalHeatAbsorbing());
    }


    @Test
    public void addingModules() {
        //Act
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule2);
        this.container.addAbsorbingModule(this.absorbingModule1);

        //Assert
        Assert.assertEquals(4_000_000_000L, this.container.getTotalEnergyOutput());
        Assert.assertEquals(2_000_000_000, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void emptyContainer() {
        //Assert
        Assert.assertEquals(0, this.container.getTotalEnergyOutput());
        Assert.assertEquals(0, this.container.getTotalHeatAbsorbing());
    }
}
