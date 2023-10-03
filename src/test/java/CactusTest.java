import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CactusTest {

    @Test
    public  void ValidationTest(){
        Cactus validCactus = new Cactus("Cactus", "Astrophytum", "Asterias",
                "Nudum", "varigated", "6", "1");

        //Test getters
        assertEquals("Cactus", validCactus.getFamily());
        assertEquals("Astrophytum", validCactus.getGenus());
        assertEquals("Asterias", validCactus.getSpecies());
        assertEquals("Nudum", validCactus.getSubspecies());
        assertEquals("varigated", validCactus.getTraits());
        assertEquals("6", validCactus.getSizeCm());
        assertEquals("1", validCactus.getCactusID());
    }

    @Test
    public void testNullSpecies() {
        assertThrows(IllegalArgumentException.class, () -> new Cactus("Family", "Genus", null, "Subspecies", "Traits", "10", "ID"));
    }

    @Test
    public void testNullGenus() {
        assertThrows(IllegalArgumentException.class, () -> new Cactus("Family", null, "Species", "Subspecies", "Traits", "10", "ID"));
    }

    @Test
    public void testNullFamily() {
        assertThrows(IllegalArgumentException.class, () -> new Cactus(null, "Genus", "Species", "Subspecies", "Traits", "10", "ID"));
    }

    @Test
    public void testNullCactusID() {
        assertThrows(IllegalArgumentException.class, () -> new Cactus("Family", "Genus", "Species", "Subspecies", "Traits", "10", null));
    }
}
