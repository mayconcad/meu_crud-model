package br.com.meu_crud.model.repository.interfaces;

import java.util.List;
import java.util.Map;

public interface RepositorioGenerico<T> {

	public List<T> buscar(Map<String, Object> params);

	public List<T> autocompletar(String valor);

}
