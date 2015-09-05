package br.com.meu_crud.model.repository.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.meu_crud.model.entities.Arquivo;
import br.com.meu_crud.model.repository.interfaces.ArquivoRepositorio;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional
public class ArquivoRepositoriesImpl extends
		QueryDslJpaRepository<Arquivo, Long> implements ArquivoRepositorio {

	@Inject
	public ArquivoRepositoriesImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Arquivo, Long>(Arquivo.class,
				entityManager.getMetamodel()), entityManager);
	}

	public Arquivo buscarUltimoArquivo() {
		BooleanBuilder predicate = new BooleanBuilder();
		// predicate.and(right)
		return null;// createQuery(predicate);
	}

}
