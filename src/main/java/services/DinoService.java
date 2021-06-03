package services;

import domain.DinoType;
import domain.Dinosaur;
import dto.DinoCreateCommand;
import dto.DinoInfo;
import org.springframework.stereotype.Service;
import repository.DinoRepository;

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
