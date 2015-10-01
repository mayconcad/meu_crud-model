package br.com.meu_crud_model.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements Dao {

	protected EntityManager manager;

	public DaoImpl() {
		manager = JPAPersistence.getEntityManager();
	}

	public <T> T criar(T entidade) {
		manager.getTransaction().begin();
		manager.persist(entidade);
		manager.getTransaction().commit();
		return entidade;
	}

	public <T> T atualizar(T entidade) {
		manager.getTransaction().begin();
		manager.merge(entidade);
		manager.getTransaction().commit();
		return entidade;
	}

	public <T> T caregar(T entidade) {
		manager.getTransaction().begin();
		manager.refresh(entidade);
		manager.getTransaction().commit();
		return entidade;
	}

	public void remover(long id) {
		manager.getTransaction().begin();
		manager.remove(id);
		manager.getTransaction().commit();

	}

	public <T> List<T> buscar(Class<T> klass, Map<String, Object> parametros) {

		List<T> list = null;
		manager.getTransaction().begin();

		StringBuffer sb = new StringBuffer();
		String result = null;

		sb.append("SELECT x FROM " + klass.getSimpleName() + " x ");
		if (parametros.size() > 0) {
			sb.append(" WHERE ");
			for (String key : parametros.keySet()) {
				if (key != null) {
					sb.append("x." + key + " = :" + key + " AND ");
				}
			}
			result = sb.substring(0, sb.length() - 4);
		} else {
			result = sb.toString();
		}

		Query query = manager.createQuery(result);

		for (String map : parametros.keySet()) {
			if (!parametros.keySet().isEmpty()) {
				query.setParameter(map, parametros.get(map));
			}
		}
		list = query.getResultList();
		manager.getTransaction().commit();
		return list;
	}
}
