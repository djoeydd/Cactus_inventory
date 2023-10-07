import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class CactusManagementService {
    private final Map<String, Cactus> cactusMap = new HashMap<>();

    public CactusManagementService() {
    }
    public CactusManagementService(DefaultTableModel tableModel) {
    }

    public void addCactus(Cactus cactus){
        if(cactusMap.containsKey(cactus.getCactusID())){
            throw new IllegalArgumentException("Cactus ID already in use");
        }
        cactusMap.put(cactus.getCactusID(), cactus);
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

    public void displayAllCactiInTable(DefaultTableModel tableModel) {
        tableModel.setRowCount(0); // Clear existing rows

        for (Map.Entry<String, Cactus> entry : cactusMap.entrySet()) {
            String cactusID = entry.getKey();
            Cactus cactus = entry.getValue();

            // Add a new row to the table model with cactus data
            tableModel.addRow(new Object[]{
                    cactusID,
                    cactus.getSpecies(),
                    cactus.getGenus(),
                    cactus.getFamily(),
                    cactus.getSubspecies(),
                    cactus.getTraits(),
                    cactus.getSizeCm()
            });
        }
    }
}
