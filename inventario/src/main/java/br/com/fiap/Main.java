package br.com.fiap;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import br.com.fiap.domain.entity.Bem;
import br.com.fiap.domain.entity.Departamento;
import br.com.fiap.domain.entity.Inventario;
import br.com.fiap.domain.entity.TipoDeBem;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Departamento departamento1 = new Departamento().setNome("Departamento A");
            Departamento departamento2 = new Departamento().setNome("Departamento B");

            em.persist(departamento1);
            em.persist(departamento2);

            TipoDeBem tipo1 = new TipoDeBem().setNome("Tipo A");
            TipoDeBem tipo2 = new TipoDeBem().setNome("Tipo B");

            em.persist(tipo1);
            em.persist(tipo2);

            Bem bem1 = new Bem()
                    .setNome("Bem 1")
                    .setTipo(tipo1)
                    .setEtiqueta("ETQ001")
                    .setLocalizacao(departamento1)
                    .setAquisicao(LocalDate.now());

            Bem bem2 = new Bem()
                    .setNome("Bem 2")
                    .setTipo(tipo2)
                    .setEtiqueta("ETQ002")
                    .setLocalizacao(departamento2)
                    .setAquisicao(LocalDate.now());

            em.persist(bem1);
            em.persist(bem2);

            Inventario inventario = new Inventario()
                    .setDepartamento(departamento1)
                    .setInicio(LocalDate.now())
                    .setFim(LocalDate.now().plusDays(5))
                    .setRelatorio("Relatório do inventário");

            em.persist(inventario);

            em.getTransaction().commit();

            Bem retrievedBem = em.find(Bem.class, bem1.getId());
            System.out.println("Retrieved Bem: " + retrievedBem);


            Long inventarioId = inventario.getId();
            Inventario retrievedInventario = em.find(Inventario.class, inventarioId);

            if (retrievedInventario != null) {
                System.out.println("Retrieved Inventario: " + retrievedInventario);
            } else {
                System.out.println("Inventario não encontrado com o ID: " + inventarioId);
            }

        } finally {
            em.close();
            emf.close();
        }
    }
}
