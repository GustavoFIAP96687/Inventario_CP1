package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "TB_BEM", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_BEM", columnNames = {"NM_BEM"})
})
public class Bem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BEM")
    @SequenceGenerator(name = "SQ_BEM", sequenceName = "SQ_BEM", initialValue = 1, allocationSize = 1)
    @Column(name = "ID_BEM")
    private Long id;

    @Column(name = "NM_BEM")
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_TIPODEBEM",
            referencedColumnName = "ID_TIPODEBEM",
            foreignKey = @ForeignKey(name = "FK_BEM_TPBEM"))
    private TipoDeBem tipo;

    @Column(name = "ETQ_BEM",nullable = false, unique = true)
    private String etiqueta;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_DEPARTAMENTO",
            referencedColumnName = "ID_DEPARTAMENTO",
            foreignKey = @ForeignKey(name = "ID_DEPARTAMENTO"))
    private Departamento localizacao;

    @Column(name = "DT_AQ")
    private LocalDate aquisicao;


    public Bem() {
    }

    public Bem(Long id, String nome, TipoDeBem tipo, String etiqueta, Departamento localizacao, LocalDate aquisicao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.etiqueta = etiqueta;
        this.localizacao = localizacao;
        this.aquisicao = aquisicao;
    }

    public Long getId() {
        return id;
    }

    public Bem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Bem setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public TipoDeBem getTipo() {
        return tipo;
    }

    public Bem setTipo(TipoDeBem tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public Bem setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
        return this;
    }

    public Departamento getLocalizacao() {
        return localizacao;
    }

    public Bem setLocalizacao(Departamento localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    public LocalDate getAquisicao() {
        return aquisicao;
    }

    public Bem setAquisicao(LocalDate aquisicao) {
        this.aquisicao = aquisicao;
        return this;
    }

    @Override
    public String toString() {
        return "Bem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", etiqueta='" + etiqueta + '\'' +
                ", localizacao=" + localizacao +
                ", aquisicao=" + aquisicao +
                '}';
    }
}
