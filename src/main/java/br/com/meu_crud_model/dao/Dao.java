package br.com.meu_crud_model.dao;

import java.util.List;
import java.util.Map;

public interface Dao {

	public <T> T criar(T entidade);

	public <T> T atualizar(T entidade);

	public <T> T caregar(T entidade);

	public <T> List<T> buscar(Class<T> klass, Map<String, Object> parametros);

	public void remover(long id);

}
