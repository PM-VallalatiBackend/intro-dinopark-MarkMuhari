package hu.progmasters.dinopark.dto;

public class DinoCreateCommand {

    private String name;
    private String breed;
    private String dinoType;

    public DinoCreateCommand() {
    }

    public String getName() {
        return name;
    }

    public DinoCreateCommand setName(String name) {
        this.name = name;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public DinoCreateCommand setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public String getDinoType() {
        return dinoType;
    }

    public DinoCreateCommand setDinoType(String dinoType) {
        this.dinoType = dinoType;
        return this;
    }
}
