package br.com.iyisakuma.dio.DesafioPOO.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
@Data
@Entity
public class Dev extends TableDB{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @ManyToMany
    @JoinTable(
            name = "dev_bootcamp",
            joinColumns = @JoinColumn(name = "dev_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bootcamp_id", referencedColumnName = "id")
    )
    private Set<Conteudo> conteudos = new LinkedHashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return id == dev.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
