package repository;

import domain.DinoType;
import domain.Dinosaur;

import java.util.List;

public interface DinoRepository {

    Dinosaur save(Dinosaur dinosaur);

    List<Dinosaur> list();

    List<Dinosaur> listByType(DinoType dinoType);

}
