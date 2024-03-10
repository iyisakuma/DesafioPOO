package br.com.iyisakuma.dio.DesafioPOO.controller;

import br.com.iyisakuma.dio.DesafioPOO.domain.Bootcamp;
import br.com.iyisakuma.dio.DesafioPOO.domain.Dev;
import br.com.iyisakuma.dio.DesafioPOO.dto.BootcampDTO;
import br.com.iyisakuma.dio.DesafioPOO.dto.DevDto;
import br.com.iyisakuma.dio.DesafioPOO.repository.BootcampRepository;
import br.com.iyisakuma.dio.DesafioPOO.repository.DevRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dev")
public class DevController {

    @Autowired
    private DevRepository repository;


    @PostMapping("/novo")
    public ResponseEntity<Dev> novo(@RequestBody @Valid DevDto dto) {
        var dev = new Dev();
        dev.setNome(dto.nome());
        dev = repository.save(dev);
        return ResponseEntity.ok(dev);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dev> getById(@PathVariable long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Dev>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
