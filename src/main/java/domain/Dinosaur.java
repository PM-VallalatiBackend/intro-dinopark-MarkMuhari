package domain;

public class Dinosaur {

    private Integer id;
    private String name;
    private String breed;
    private DinoType dinoType;

    public Dinosaur() {
    }

    public Dinosaur(String name, String breed, DinoType dinoType) {
        this.name = name;
        this.breed = breed;
        this.dinoType = dinoType;
    }

    public Integer getId() {
        return id;
    }

    public Dinosaur setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dinosaur setName(String name) {
        this.name = name;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public Dinosaur setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public DinoType getDinoType() {
        return dinoType;
    }

    public Dinosaur setDinoType(DinoType dinoType) {
        this.dinoType = dinoType;
        return this;
    }
}
