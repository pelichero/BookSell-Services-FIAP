package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Livros;

@Stateless
public class LivrosBean implements LivrosBeanRemote {
	@PersistenceContext(unitName = "fiapPU")
	private EntityManager em;

	@Override
	public void add(Livros livro) {
		em.persist(livro);
	}

	@Override
	public List<Livros> getAll() {
		TypedQuery<Livros> query = em.createQuery("select u from Livros u", Livros.class);
		return query.getResultList();
	}
}