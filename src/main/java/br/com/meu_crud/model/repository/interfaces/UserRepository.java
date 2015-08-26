package br.com.meu_crud.model.repository.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meu_crud.model.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

	Usuario loadUserByUsername(String username);

	void changePassword(String userName, String newPassword);

	Usuario loadCurrentUser();

	List<Usuario> buscar(Map<String, Object> params);

}
