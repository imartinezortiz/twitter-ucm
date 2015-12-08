package es.ucm.fdi.users.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.users.business.entity.User;
import es.ucm.fdi.users.business.entity.UserRole;

@Repository
public class UserRepository implements es.ucm.fdi.users.business.control.UserRepository {

	private Map<Long, User> entities;

	private long idGenerator;

	public UserRepository() {
		this.entities = new HashMap<>();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		User u = new User("root", "root@example.ucm.es");
		u.setPassword(encoder.encode("root"));
		u.addRole(new UserRole("ROLE_USER"));
		u.addRole(new UserRole("ROLE_ADMIN"));

		this.entities.put(this.idGenerator++, u);

		u = new User("user", "user@example.ucm.es");
		u.setPassword(encoder.encode("user"));
		u.addRole(new UserRole("ROLE_USER"));

		this.entities.put(this.idGenerator++, u);
	}

	public User findByUsername(String username) {
		for (User u : entities.values()) {
			if (u.getUsername().equals(username)) {
				return u.copy();
			}
		}
		return null;
	}

	public User findByEmail(String email) {
		for (User u : entities.values()) {
			if (u.getEmail().equals(email)) {
				return u.copy();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String[] passwords = { "root", "user" };
		for (int i = 0; i < passwords.length; i++) {
			System.out.println(passwords[i] + ": " + encoder.encode(passwords[i]));
		}
	}

	@Override
	public User save(User entity) {
		User result = entity.copy();
		entities.put(idGenerator++, result);
		return result;
	}

	@Override
	public User findOne(Long id) {
		User user = entities.get(id).copy();
		return user;
	}
}