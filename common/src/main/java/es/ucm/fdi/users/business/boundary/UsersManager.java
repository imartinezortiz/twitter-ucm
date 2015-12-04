package es.ucm.fdi.users.business.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.ucm.fdi.users.business.control.UserRepository;
import es.ucm.fdi.users.business.entity.User;
import es.ucm.fdi.users.business.entity.UserRole;

@Service
public class UsersManager implements UserDetailsService {

	private UserRepository users;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UsersManager(UserRepository usuarios, PasswordEncoder passwordEncoder) {
		this.users = usuarios;
		this.passwordEncoder = passwordEncoder;
	}
	
	public User getUser(long idUsuario) {
		return users.findOne(idUsuario);
	}

	public User getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if ( principal instanceof User) {
			return (User) principal;
		}
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails user = users.findByEmail(username);
		if (user == null)  {
			user = users.findByUsername(username);
		}
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s not found", username));
		}
		
		return user;
	}

	public User createUser(CreateUser newUser) {
		User user = new User(newUser.getUsername(), newUser.getEmail());
		user.addRole(new UserRole("ROLE_USER"));
		user.setPassword(passwordEncoder.encode(newUser.getPassword()));
		user = users.save(user);
		
		return user;
	}
}
