package br.com.iyisakuma.dio.DesafioPOO.controller;

import br.com.iyisakuma.dio.DesafioPOO.domain.Conteudo;
import br.com.iyisakuma.dio.DesafioPOO.domain.Curso;
import br.com.iyisakuma.dio.DesafioPOO.dto.CursoDTO;
import br.com.iyisakuma.dio.DesafioPOO.repository.ConteudoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController()
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private ConteudoRepository repository;

    @PostMapping("/novo")
    public ResponseEntity<Curso> novo(@RequestBody @Valid  CursoDTO dto){
        var curso = new Curso();
        curso.setDescricao(dto.descricao());
        curso.setTitulo(dto.titulo());
        curso.setCargaHoraria(dto.cargaHoraria());
        repository.save(curso);
        return ResponseEntity.ok(curso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable long id){
        Curso curso = (Curso) repository.findById(id).get();
        return ResponseEntity.ok(curso);
    }
}
