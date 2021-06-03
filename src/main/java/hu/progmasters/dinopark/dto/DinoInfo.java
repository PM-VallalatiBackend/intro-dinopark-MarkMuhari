package hu.progmasters.dinopark.dto;

public class DinoInfo {

    private Integer id;
    private String name;
    private String breed;
    private String dinoType;

    public DinoInfo() {
    }

    public Integer getId() {
        return id;
    }

    public DinoInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DinoInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public DinoInfo setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public String getDinoType() {
        return dinoType;
    }

    public DinoInfo setDinoType(String dinoType) {
        this.dinoType = dinoType;
        return this;
    }
}
