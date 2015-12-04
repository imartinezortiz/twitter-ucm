package es.ucm.fdi.users.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
	public <S extends User> S save(S entity) {
		S result = (S) entity.copy();
		entities.put(idGenerator++, result);
		return result;
	}
	
	@Override
	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		final Collection<S> result = new ArrayList<>();
		for(S e : entities) {
			result.add(save(e));
		}
		return new Iterable<S>() {
			@Override
			public Iterator<S> iterator() {
				return result.iterator();
			}
			
		};
	}

	@Override
	public User findOne(Long id) {
		User user = entities.get(id).copy();
		return user;
	}

	@Override
	public boolean exists(Long id) {
		return this.entities.containsKey(id);
	}

	@Override
	public Iterable<User> findAll() {
		Collection<User> result = new LinkedList<>();
		result.addAll(this.entities.values());
		return result;
	}

	@Override
	public Iterable<User> findAll(Iterable<Long> ids) {
		Collection<User> result = new LinkedList<>();
		for (Long id : ids) {
			if (this.entities.containsKey(id)) {
				result.add(this.entities.get(id));
			}
		}
		return result;
	}

	@Override
	public long count() {
		return this.entities.size();
	}

	@Override
	public void delete(Long id) {
		this.entities.remove(id);
	}

	@Override
	public void delete(User entity) {
		for (Map.Entry<Long, User> e : this.entities.entrySet()) {
			if (e.getValue().equals(entity)) {
				this.entities.remove(e.getKey());
				break;
			}
		}
	}

	@Override
	public void delete(Iterable<? extends User> entities) {
		for (User entity : entities) {
			for (Map.Entry<Long, User> e : this.entities.entrySet()) {
				if (e.getValue().equals(entity)) {
					this.entities.remove(e.getKey());
					break;
				}
			}
		}
	}

	@Override
	public void deleteAll() {
		this.entities.clear();
	}
}