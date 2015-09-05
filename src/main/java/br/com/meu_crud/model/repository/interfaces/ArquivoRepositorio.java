package br.com.meu_crud.model.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meu_crud.model.entities.Arquivo;

public interface ArquivoRepositorio extends JpaRepository<Arquivo, Long> {

	// busca o ultimo arquivo com base na data
	public Arquivo buscarUltimoArquivo();

}
