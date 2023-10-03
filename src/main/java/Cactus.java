public class Cactus {
    private String species;
    private String genus;
    private String family;
    private String subspecies;
    private String traits;
    private String sizeCm;
    private final String cactusID;

    public Cactus(String family, String genus, String species, String subspecies, String traits, String sizeCm, String cactusID) {

        if(species == null || species.isEmpty()) {
            throw new IllegalArgumentException("Species should not be empty");
        }
        this.species = species;

        if(genus == null || genus.isEmpty()){
            throw new IllegalArgumentException("Genus should not be blank");
        }
        this.genus = genus;

        if(family == null || family.isEmpty()){
            throw new IllegalArgumentException("Family should not be blank");
        }
        this.family = family;

        if(cactusID == null || cactusID.isEmpty()){
            throw new IllegalArgumentException("ID cannot be blank");
        }
        this.cactusID = cactusID;

        this.traits = traits;
        this.subspecies = subspecies;
        this.sizeCm = sizeCm;
    }

    public String getGenus() {
        return genus;
    }

    public String getCactusID() {
        return cactusID;
    }

    public String getFamily() {
        return family;
    }

    public String getSizeCm() {
        return sizeCm;
    }

    public String getSpecies() {
        return species;
    }

    public String getTraits() {
        return traits;
    }

    public String getSubspecies() {
        return subspecies;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setSizeCm(String sizeCm) {
        this.sizeCm = sizeCm;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }
}
