package br.com.iyisakuma.dio.DesafioPOO.controller;

import br.com.iyisakuma.dio.DesafioPOO.domain.Mentoria;
import br.com.iyisakuma.dio.DesafioPOO.dto.MentoriaDto;
import br.com.iyisakuma.dio.DesafioPOO.repository.MentoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentoria")
public class MentoriaController {

    @Autowired
    private MentoriaRepository repository;


    @PostMapping("/novo")
    public ResponseEntity<Mentoria> novo(@RequestBody @Valid MentoriaDto dto) {
        var mentoria = new Mentoria();
        mentoria.setData(dto.date());
        mentoria.setDescricao(dto.descricao());
        mentoria.setTitulo(dto.titulo());
        mentoria = repository.save(mentoria);
        return ResponseEntity.ok(mentoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mentoria> getById(@PathVariable long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Mentoria>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
