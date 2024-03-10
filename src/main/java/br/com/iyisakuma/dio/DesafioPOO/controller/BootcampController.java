package br.com.iyisakuma.dio.DesafioPOO.controller;

import br.com.iyisakuma.dio.DesafioPOO.domain.Bootcamp;
import br.com.iyisakuma.dio.DesafioPOO.dto.BootcampConteudoDTO;
import br.com.iyisakuma.dio.DesafioPOO.dto.BootcampDTO;
import br.com.iyisakuma.dio.DesafioPOO.dto.BootcampDevDTO;
import br.com.iyisakuma.dio.DesafioPOO.repository.BootcampRepository;
import br.com.iyisakuma.dio.DesafioPOO.repository.ConteudoRepository;
import br.com.iyisakuma.dio.DesafioPOO.repository.DevRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bootcamp")
public class BootcampController {

    @Autowired
    private BootcampRepository bootcampRepository;
    @Autowired
    private ConteudoRepository conteudoRepository;
    @Autowired
    private DevRepository devRepository;


    @PostMapping("/novo")
    public ResponseEntity<Bootcamp> novo(@RequestBody @Valid BootcampDTO dto) {
        var bootcamp = new Bootcamp();
        bootcamp.setDescricao(dto.descricao());
        bootcamp = bootcampRepository.save(bootcamp);
        return ResponseEntity.ok(bootcamp);
    }

    @PostMapping("/add-conteudo")
    public ResponseEntity<Bootcamp>  registraCurso(@RequestBody BootcampConteudoDTO dto) throws Exception {
        var bootcamp = bootcampRepository.findById(dto.idBootcamp()).orElseThrow(EntityNotFoundException::new);
        var conteudo = conteudoRepository.findById(dto.idConteudo()).orElseThrow(EntityNotFoundException::new);
        bootcamp.add(conteudo);
        return ResponseEntity.ok(bootcampRepository.save(bootcamp));
    }

    @PostMapping("/add-dev")
    public ResponseEntity<Bootcamp>  registraCurso(@RequestBody BootcampDevDTO dto) throws Exception {
        var bootcamp = bootcampRepository.findById(dto.idBootcamp()).orElseThrow(EntityNotFoundException::new);
        var dev = devRepository.findById(dto.idDev()).orElseThrow(EntityNotFoundException::new);
        bootcamp.add(dev);
        return ResponseEntity.ok(bootcampRepository.save(bootcamp));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bootcamp> getById(@PathVariable long id){
        return ResponseEntity.ok(bootcampRepository.findById(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Bootcamp>> findAll(){
        return ResponseEntity.ok(bootcampRepository.findAll());
    }
}
