package es.ucm.fdi.users.business.control;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.users.business.entity.User;

@Repository
public interface UserRepository {

	public UserDetails findByEmail(String username);

	public UserDetails findByUsername(String username);

	public User findOne(Long idUsuario);

	public User save(User user);
	
}