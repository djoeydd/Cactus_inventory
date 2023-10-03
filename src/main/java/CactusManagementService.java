import java.util.HashMap;
import java.util.Map;

public class CactusManagementService {
    private final Map<String, Cactus> cactusMap = new HashMap<>();

    public void addCactus(Cactus cactus){
        if(cactusMap.containsKey(cactus.getCactusID())){
            throw new IllegalArgumentException("Cactus ID already in use");
        }
        cactusMap.put(cactus.getCactusID(), cactus);
        displayAllCacti();
    }

    public void deleteCactus(String cactusID){
        if(!cactusMap.containsKey(cactusID)){
            throw new IllegalArgumentException("Cactus not found");
        }
        cactusMap.remove(cactusID);
    }

    public void updateCactus(String cactusID, String field, String value){
        Cactus cactus = cactusMap.get(cactusID);

        switch (field) {
            case "species" -> cactus.setSpecies(value);
            case "genus" -> cactus.setGenus(value);
            case "family" -> cactus.setFamily(value);
            case "subspecies" -> cactus.setSubspecies(value);
            case "traits" -> cactus.setTraits(value);
            case "sizeCm" -> cactus.setSizeCm(value);
            default -> throw new IllegalArgumentException("Invalid field name: " + field);
        }
    }

    public Cactus getCactusByID(String cactusID){
        return cactusMap.get(cactusID);
    }

    public void displayAllCacti() {
        System.out.println("All Cacti:");

        for (Map.Entry<String, Cactus> entry : cactusMap.entrySet()) {
            String cactusID = entry.getKey();
            Cactus cactus = entry.getValue();

            System.out.println("Cactus ID: " + cactusID);
            System.out.println("Species: " + cactus.getSpecies());
            System.out.println("Genus: " + cactus.getGenus());
            System.out.println("Family: " + cactus.getFamily());
            System.out.println("Subspecies: " + cactus.getSubspecies());
            System.out.println("Traits: " + cactus.getTraits());
            System.out.println("Size (cm): " + cactus.getSizeCm());
            System.out.println();
        }
    }
}