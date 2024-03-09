package br.com.iyisakuma.dio.DesafioPOO.service;

import br.com.iyisakuma.dio.DesafioPOO.domain.Conteudo;
import br.com.iyisakuma.dio.DesafioPOO.domain.Dev;
import br.com.iyisakuma.dio.DesafioPOO.repository.ConteudoRepository;
import br.com.iyisakuma.dio.DesafioPOO.repository.HistoricoMatriculaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConteudoService {
    private final ConteudoRepository conteudoRepository;
    private final HistoricoMatriculaRepository historicoMatriculaRepository;

    public ConteudoService(ConteudoRepository conteudoRepository, HistoricoMatriculaRepository historicoMatriculaRepository) {
        this.conteudoRepository = conteudoRepository;
        this.historicoMatriculaRepository = historicoMatriculaRepository;
    }

    public void finaliza(Dev dev, Conteudo conteudo){
        var historicoMatricula = historicoMatriculaRepository.findHistoricoMatriculaByDevAndConteudo(dev, conteudo);
        historicoMatricula.setDtFinalizado(LocalDate.now());
        historicoMatriculaRepository.save(historicoMatricula);
        conteudoRepository.save(conteudo);
    }
}
