import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CactusManagementServiceTest {

    @Test
    public void addCactusTest(){
        CactusManagementService cactusManagementService = new CactusManagementService();
        Cactus validCactus = new Cactus("Cactus", "Astrophytum", "Asterias",
                "Nudum", "varigated", "6", "1");

        //Add valid cactus
        cactusManagementService.addCactus(validCactus);
        assertEquals(validCactus, cactusManagementService.getCactusByID("1"));

        //Add cactus with duplicate ID
        assertThrows(IllegalArgumentException.class, () -> cactusManagementService.addCactus(validCactus));
    }

    @Test
    public void testAddCactusWithEmptySpecies() {
        CactusManagementService cactusManagementService = new CactusManagementService();

        assertThrows(IllegalArgumentException.class, () -> cactusManagementService.addCactus(new Cactus("family", "genus", "", "subspecies", "traits", "size", "ID")));
    }

    @Test
    public void testAddCactusWithEmptyGenus() {
        CactusManagementService cactusManagementService = new CactusManagementService();

        assertThrows(IllegalArgumentException.class, () -> cactusManagementService.addCactus(new Cactus("family", "", "species", "subspecies", "traits", "size", "ID")));
    }

    @Test
    public void testAddCactusWithEmptyFamily() {
        CactusManagementService cactusManagementService = new CactusManagementService();

        assertThrows(IllegalArgumentException.class, () -> cactusManagementService.addCactus(new Cactus("", "genus", "species", "subspecies", "traits", "size", "ID")));
    }

    @Test
    public void deleteCactusTest(){
        CactusManagementService cactusManagementService = new CactusManagementService();
        Cactus cactus1 = new Cactus("Cactus", "Astrophytum", "Asterias",
                "Nudum", "varigated", "6", "1");
        Cactus cactus2 = new Cactus("Cactus", "Astrophytum", "Asterias",
                "Nudum", "varigated", "6", "2");

        cactusManagementService.addCactus(cactus1);
        cactusManagementService.addCactus(cactus2);

        //Deleting existing cactus
        cactusManagementService.deleteCactus("2");
        assertNull(cactusManagementService.getCactusByID("2"));

        //Deleting non-existing cactus
        assertThrows(IllegalArgumentException.class, () -> cactusManagementService.deleteCactus("3"));
    }

    @Test
    public void updateSpeciesTest() {
        CactusManagementService cactusManagementService = new CactusManagementService();
        Cactus cactus = new Cactus("Cactus", "Astrophytum", "Asterias", "Nudum", "variegated", "6", "1");
        cactusManagementService.addCactus(cactus);

        // Update the species of the cactus
        cactusManagementService.updateCactus("1", "species", "New Species");
        assertEquals("New Species", cactusManagementService.getCactusByID("1").getSpecies());
    }

    @Test
    public void updateGenusTest() {
        CactusManagementService cactusManagementService = new CactusManagementService();
        Cactus cactus = new Cactus("Cactus", "Astrophytum", "Asterias", "Nudum", "variegated", "6", "1");
        cactusManagementService.addCactus(cactus);

        // Update the genus of the cactus
        cactusManagementService.updateCactus("1", "genus", "New Genus");
        assertEquals("New Genus", cactusManagementService.getCactusByID("1").getGenus());
    }

    @Test
    public void updateFamilyTest() {
        CactusManagementService cactusManagementService = new CactusManagementService();
        Cactus cactus = new Cactus("Cactus", "Astrophytum", "Asterias", "Nudum", "variegated", "6", "1");
        cactusManagementService.addCactus(cactus);

        // Update the family of the cactus
        cactusManagementService.updateCactus("1", "family", "New Family");
        assertEquals("New Family", cactusManagementService.getCactusByID("1").getFamily());
    }

    @Test
    public void updateSubspeciesTest() {
        CactusManagementService cactusManagementService = new CactusManagementService();
        Cactus cactus = new Cactus("Cactus", "Astrophytum", "Asterias", "Nudum", "variegated", "6", "1");
        cactusManagementService.addCactus(cactus);

        // Update the subspecies of the cactus
        cactusManagementService.updateCactus("1", "subspecies", "New Subspecies");
        assertEquals("New Subspecies", cactusManagementService.getCactusByID("1").getSubspecies());
    }

    @Test
    public void updateTraitsTest() {
        CactusManagementService cactusManagementService = new CactusManagementService();
        Cactus cactus = new Cactus("Cactus", "Astrophytum", "Asterias", "Nudum", "variegated", "6", "1");
        cactusManagementService.addCactus(cactus);

        // Update the traits of the cactus
        cactusManagementService.updateCactus("1", "traits", "New Traits");
        assertEquals("New Traits", cactusManagementService.getCactusByID("1").getTraits());
    }

    @Test
    public void updateSizeCmTest() {
        CactusManagementService cactusManagementService = new CactusManagementService();
        Cactus cactus = new Cactus("Cactus", "Astrophytum", "Asterias", "Nudum", "variegated", "6", "1");
        cactusManagementService.addCactus(cactus);

        // Update the sizeCm of the cactus
        cactusManagementService.updateCactus("1", "sizeCm", "10");
        assertEquals("10", cactusManagementService.getCactusByID("1").getSizeCm());
    }
}