package controller;

import dto.DinoCreateCommand;
import dto.DinoInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DinoService;

import java.util.List;

@RestController
@RequestMapping("/api/dino")
public class DinoController {

    private DinoService dinoService;

    public DinoController(DinoService dinoService) {
        this.dinoService = dinoService;
    }

    @PostMapping
    public ResponseEntity<DinoInfo> save(@RequestBody DinoCreateCommand command) {

        DinoInfo dinoInfo = dinoService.save(command);
        return new ResponseEntity<>(dinoInfo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DinoInfo>> list() {
        List<DinoInfo> dinoInfos = dinoService.list();
        return new ResponseEntity<>(dinoInfos, HttpStatus.OK);
    }
}
