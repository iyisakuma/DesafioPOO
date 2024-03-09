package br.com.iyisakuma.dio.DesafioPOO.service;

import br.com.iyisakuma.dio.DesafioPOO.domain.*;
import br.com.iyisakuma.dio.DesafioPOO.exception.DevNaoMatriculadoNoCursoException;
import br.com.iyisakuma.dio.DesafioPOO.repository.BootcampRepository;
import br.com.iyisakuma.dio.DesafioPOO.repository.DevRepository;
import br.com.iyisakuma.dio.DesafioPOO.repository.HistoricoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DevService {

    @Autowired
    private HistoricoMatriculaRepository historicoMatriculaRepository;
    @Autowired
    private DevRepository devRepository;
    @Autowired
    private BootcampRepository bootcampRepository;
    @Autowired
    private ConteudoService conteudoService;



    public void inscreve(Dev dev, Bootcamp bootcamp){
        bootcamp.add(dev);
        bootcampRepository.save(bootcamp);
        bootcamp.getConteudoProgramatico().forEach(conteudo -> inscreve(dev, conteudo));

    }

    public void inscreve(Dev dev, Conteudo conteudo){
        var historico = new HistoricoMatricula();
        historico.setConteudo(conteudo);
        historico.setDtCreate(LocalDate.now());
        historico.setDtUpdate(LocalDate.now());
        historicoMatriculaRepository.save(historico);
        dev.add(historico);
        devRepository.save(dev);
    }

    public boolean conclui(Dev dev, Curso curso) throws DevNaoMatriculadoNoCursoException{
        if(podeFinalizar(dev, curso)){
            conteudoService.finaliza(dev, curso);
            return true;
        }
        return false;
    }

    private boolean podeFinalizar(Dev dev, Curso curso) {
        return historicoMatriculaRepository
                .findByDevAndConteudoAndDtFinalizadoIsNull(dev, curso)
                .isPresent();
    }

    public BigDecimal calcularTotalXp(Dev dev){
        return dev.getHistoricoMatriculas()
                .stream()
                .map(HistoricoMatricula::getConteudo)
                .map(Conteudo::getXp)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
