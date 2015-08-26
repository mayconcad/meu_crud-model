package br.com.meu_crud.model.repository.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.meu_crud.model.entities.Arquivo;
import br.com.meu_crud.model.entities.QArquivo;
import br.com.meu_crud.model.repository.interfaces.ArquivoRepositorio;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional(readOnly = true)
public class ArquivoRepositoriesImpl extends
		QueryDslJpaRepository<Arquivo, Long> implements ArquivoRepositorio {

	private QArquivo qArquivo = QArquivo.arquivo;

	@Inject
	public ArquivoRepositoriesImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Arquivo, Long>(Arquivo.class,
				entityManager.getMetamodel()), entityManager);
	}

	@Override
	public Arquivo buscarUltimoArquivo() {
		return createQuery().orderBy(qArquivo.dataRegistro.desc())
				.singleResult(qArquivo);
	}

	@Override
	public List<Arquivo> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(qArquivo.nome.eq(params.get("nome").toString()));
		return createQuery(predicate).listDistinct(qArquivo);
	}

	@Override
	public List<Arquivo> autocompletar(String valor) {
		return null;
	}
}
