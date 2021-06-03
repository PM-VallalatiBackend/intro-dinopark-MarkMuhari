package hu.progmasters.dinopark.services;

import hu.progmasters.dinopark.domain.DinoType;
import hu.progmasters.dinopark.domain.Dinosaur;
import hu.progmasters.dinopark.dto.DinoCreateCommand;
import hu.progmasters.dinopark.dto.DinoInfo;
import hu.progmasters.dinopark.repository.DinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DinoService {


    private DinoRepository dinoRepository;

    public DinoService(DinoRepository dinoRepository) {
        this.dinoRepository = dinoRepository;
    }

    public DinoInfo save(DinoCreateCommand command) {

        // a commandból megcsinálni a Dinosaurt
        Dinosaur dinosaur = convertToDinosaur(command);

        // elmentenni a repoba a Dinot
        Dinosaur dinosaurSaved = dinoRepository.save(dinosaur);

        // a visszakapott elmentett példányt átlakítanni DinoInfová
        return convertToInfo(dinosaurSaved);
    }

    public List<DinoInfo> list() {
        return dinoRepository.list()
                .stream()
                    .map(dinosaur -> convertToInfo(dinosaur))
                        .collect(Collectors.toList());
    }

    public List<DinoInfo> listByType(DinoType type) {
        return dinoRepository.listByType(type)
                .stream()
                .map(dinosaur -> convertToInfo(dinosaur))
                .collect(Collectors.toList());
    }

    private Dinosaur convertToDinosaur(DinoCreateCommand command) {
        return new Dinosaur()
                .setName(command.getName())
                .setBreed(command.getBreed())
                .setDinoType(DinoType.valueOf(command.getDinoType().toUpperCase()));
    }

    private DinoInfo convertToInfo(Dinosaur dinosaur) {
        return new DinoInfo()
                .setId(dinosaur.getId())
                .setName(dinosaur.getName())
                .setBreed(dinosaur.getBreed())
                .setDinoType(dinosaur.getDinoType().name().toUpperCase());
    }
}
