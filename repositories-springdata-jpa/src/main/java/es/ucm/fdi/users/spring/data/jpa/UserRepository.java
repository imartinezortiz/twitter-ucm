package es.ucm.fdi.users.spring.data.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.users.business.entity.User;

@Repository
public interface UserRepository extends es.ucm.fdi.users.business.control.UserRepository, CrudRepository<User, Long> {

	public UserDetails findByEmail(String username);

	public UserDetails findByUsername(String username);
	
}