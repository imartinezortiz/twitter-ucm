package es.ucm.fdi.users.business.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.users.business.entity.User;
import es.ucm.fdi.users.business.entity.UserRole;

@Repository
public class UserRepository {

	private Map<Long, User> users;
	
	private long idGenerator;
	
	public UserRepository() {
		this.users = new HashMap<>();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		User u = new User("root", "root@example.ucm.es");
		u.setPassword(encoder.encode("root"));
		u.addRole(new UserRole("ROLE_USER"));
		u.addRole(new UserRole("ROLE_ADMIN"));
		
		this.users.put(0l, u);
		
		u = new User("user", "user@example.ucm.es");
		u.setPassword(encoder.encode("user"));
		u.addRole(new UserRole("ROLE_USER"));
		
		this.users.put(1l, u);
		
		this.idGenerator = 2;
	}
	
	public User getUser(long idUsuario) {
		User user = users.get(idUsuario).copy();
		return user;
	}
	
	public User findByUsername(String username) {
		for(User u : users.values()) {
			if (u.getUsername().equals(username)) {
				return u.copy();
			}
		}
		return null;
	}
	
	public User findByEmail(String email) {
		for(User u : users.values()) {
			if (u.getEmail().equals(email)) {
				return u.copy();
			}
		}
		return null;
	}

	public User save(User user) {
		users.put(idGenerator++, user);
		return user;
	}

}
