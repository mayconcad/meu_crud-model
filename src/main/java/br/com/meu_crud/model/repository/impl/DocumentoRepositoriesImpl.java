package br.com.meu_crud.model.repository.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.meu_crud.model.entities.Documento;
import br.com.meu_crud.model.entities.QDocumento;
import br.com.meu_crud.model.repository.interfaces.DocumentoRepositorio;

import com.mysema.query.BooleanBuilder;

@Repository
@Transactional(readOnly = true)
public class DocumentoRepositoriesImpl extends
		QueryDslJpaRepository<Documento, Long> implements DocumentoRepositorio {

	private QDocumento qDocumento = QDocumento.documento;

	@Inject
	public DocumentoRepositoriesImpl(EntityManager entityManager) {
		super(new JpaMetamodelEntityInformation<Documento, Long>(
				Documento.class, entityManager.getMetamodel()), entityManager);
	}

	public List<Documento> buscar(Map<String, Object> params) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (params.containsKey("titulo"))
			predicate
					.and(qDocumento.titulo.eq(params.get("titulo").toString()));
		return createQuery(predicate).listDistinct(qDocumento);
	}

	public List<Documento> autocompletar(String valor) {
		BooleanBuilder predicate = new BooleanBuilder();
		if (valor != null)
			predicate.and(qDocumento.titulo.containsIgnoreCase(valor));
		return createQuery(predicate).listDistinct(qDocumento);
	}
}
