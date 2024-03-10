package br.com.iyisakuma.dio.DesafioPOO.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Bootcamp extends TableDB {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;
    private String descricao;
    private final LocalDate dtInicial = LocalDate.now();
    private final LocalDate dtFinal = LocalDate.now().plusDays(45);

    @ManyToMany
    @JoinTable(
            name = "bootcamp_conteudo",
            joinColumns = @JoinColumn(name = "bootcamp_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "conteudo_id", referencedColumnName = "id")
    )
    private Set<Conteudo> conteudoProgramatico = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "bootcamp_dev",
            joinColumns = @JoinColumn(name = "bootcamp_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="dev_id", referencedColumnName = "id")

    )
    private Set<Dev> devInscritos = new HashSet<>();


    public void add(Conteudo conteudo){
        conteudoProgramatico.remove(conteudo);
    }

    public void remove(Conteudo conteudo){
        conteudoProgramatico.remove(conteudo);
    }

    public void add(Dev devInscrito){
        devInscritos.add(devInscrito);
    }

    public void remove(Dev devInscrito){
        devInscritos.remove(devInscrito);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return id == bootcamp.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
