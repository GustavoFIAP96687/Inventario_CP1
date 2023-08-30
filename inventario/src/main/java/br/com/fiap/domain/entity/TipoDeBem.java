package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TP_BEM", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_TP_BEM", columnNames = {"NM_TP_BEM"})
})
public class TipoDeBem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TP_BEM")
    @SequenceGenerator(name = "SQ_TP_BEM", sequenceName = "SQ_TP_BEM", initialValue = 1, allocationSize = 1)
    @Column(name = "ID_TIPODEBEM")
    private Long id;

    @Column(name = "NM_TP_BEM", unique = true, nullable = false)
    private String nome;

    public TipoDeBem() {
    }

    public TipoDeBem(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public TipoDeBem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeBem setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "TipoDeBem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
