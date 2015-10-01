package br.com.meu_crud_model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAPersistence {

	private static EntityManager factory;

	private JPAPersistence() {
	}

	public static EntityManager getEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("meu_crud")
					.createEntityManager();
		}
		return factory;
	}
}
