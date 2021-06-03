package repository;

import domain.DinoType;
import domain.Dinosaur;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DinoRepositoryInMemory implements DinoRepository {

    private Map<Integer, Dinosaur> dinosaurs = new HashMap<>();
    private int lastIndexUsed;

    @Override
    public Dinosaur save(Dinosaur dinosaur) {
        lastIndexUsed++;
        dinosaur.setId(lastIndexUsed);
        dinosaurs.put(lastIndexUsed, dinosaur);
        return dinosaur;
    }

    @Override
    public List<Dinosaur> list() {
        return dinosaurs.values()
                .stream()
                .sorted(Comparator.comparing(Dinosaur::getId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dinosaur> listByType(DinoType dinoType) {
        return dinosaurs.values().stream()
                .filter(dinosaur -> dinosaur.getDinoType().equals(dinoType))
                .sorted(Comparator.comparing(Dinosaur::getId))
                .collect(Collectors.toList());
    }
}
