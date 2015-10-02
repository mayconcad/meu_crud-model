package br.com.meu_crud.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meu_crud.model.entities.Documento;

public interface DocumentoRepositorio extends JpaRepository<Documento, Long>,
		RepositorioGenerico<Documento> {

}
