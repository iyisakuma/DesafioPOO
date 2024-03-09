package br.com.iyisakuma.dio.DesafioPOO.repository;

import br.com.iyisakuma.dio.DesafioPOO.domain.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevRepository extends JpaRepository<Dev, Long> {
}
