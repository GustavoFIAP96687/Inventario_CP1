package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_DEPARTAMENTO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_DEPARTAMENTO", columnNames = {"NM_DEPARTAMENTO"})
})
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DEPARTAMENTO")
    @SequenceGenerator(name = "SQ_DEPARTAMENTO", sequenceName = "SQ_DEPARTAMENTO", initialValue = 1, allocationSize = 1)
    @Column(name = "ID_DEPARTAMENTO")
    private Long id;

    @Column(name = "NM_DEPARTAMENTO", unique = true, nullable = false)
    private String nome;

    public Departamento() {
    }

    public Departamento(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Departamento setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Departamento setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
