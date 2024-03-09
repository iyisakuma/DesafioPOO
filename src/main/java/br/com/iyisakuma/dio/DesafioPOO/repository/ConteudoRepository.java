package br.com.iyisakuma.dio.DesafioPOO.repository;

import br.com.iyisakuma.dio.DesafioPOO.domain.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {
}
