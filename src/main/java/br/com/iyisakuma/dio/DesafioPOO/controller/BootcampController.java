package br.com.iyisakuma.dio.DesafioPOO.controller;

import br.com.iyisakuma.dio.DesafioPOO.domain.Bootcamp;
import br.com.iyisakuma.dio.DesafioPOO.dto.BootcampDTO;
import br.com.iyisakuma.dio.DesafioPOO.repository.BootcampRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bootcamp")
public class BootcampController {

    @Autowired
    private BootcampRepository repository;


    @PostMapping("/novo")
    public ResponseEntity<Bootcamp> novo(@RequestBody @Valid BootcampDTO dto) {
        var bootcamp = new Bootcamp();
        bootcamp.setDescricao(dto.descricao());
        bootcamp = repository.save(bootcamp);
        return ResponseEntity.ok(bootcamp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bootcamp> getById(@PathVariable long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Bootcamp>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
