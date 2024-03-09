package br.com.iyisakuma.dio.DesafioPOO.repository;

import br.com.iyisakuma.dio.DesafioPOO.domain.Conteudo;
import br.com.iyisakuma.dio.DesafioPOO.domain.Dev;
import br.com.iyisakuma.dio.DesafioPOO.domain.HistoricoMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoricoMatriculaRepository extends JpaRepository<HistoricoMatricula, Long> {

    @Query(
            """
                SELECT historico
                FROM Dev dev JOIN dev.historicoMatriculas historico 
                WHERE dev = :dev AND historico.conteudo = :conteudo
            """
    )
    HistoricoMatricula findHistoricoMatriculaByDevAndConteudo(@Param("dev")Dev dev, @Param("conteudo")Conteudo conteudo);
    @Query(
            """
                    SELECT historico
                    FROM Dev dev JOIN dev.historicoMatriculas historico
                    WHERE dev = :dev AND historico.conteudo = :conteudo AND historico.dtFinalizado IS NULL 
            """
    )
    Optional<HistoricoMatricula> findByDevAndConteudoAndDtFinalizadoIsNull(@Param("dev") Dev dev, @Param("conteudo") Conteudo conteudo);
}
