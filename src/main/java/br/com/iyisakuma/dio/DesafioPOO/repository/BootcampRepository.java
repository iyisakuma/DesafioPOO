package br.com.iyisakuma.dio.DesafioPOO.repository;

import br.com.iyisakuma.dio.DesafioPOO.domain.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Long> {

}
