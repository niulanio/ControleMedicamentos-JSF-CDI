package io.gitgub.niulaniobm.dao;

import java.io.Serializable;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import io.github.niulaniobm.model.Base;

public class DAO<T extends Base> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static EntityManager em = ConnectionFactory.getEntityManager();

	public T buscarPorId(Class<T> clazz, Long id) {
		return em.find(clazz, id);
	}

	public void salvar(T t) {
		try {
			em.getTransaction().begin();

			if (t.getId() == null) {
				em.persist(t);
			} else {
				em.merge(t);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public void remover(Class<T> clazz, Long id) {
		T t = buscarPorId(clazz, id);

		try {
			em.getTransaction().begin();

			em.remove(t);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(String jpql){
		Query query = em.createQuery(jpql);
		
		return query.getResultList();
		
	}

}
