package es.ucm.fdi.users.business.entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User  implements UserDetails, CredentialsContainer, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int USERNAME_MAX_LENGTH = 20;

	public static final int USERNAME_MIN_LENGTH = 5;

	public static final int PASSWORD_MIN_LENGTH = 5;

	public static final int PASSWORD_MAX_LENGTH = 30;

	private Long id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private boolean accountExpired;
	
	private boolean accountLocked;
	
	private boolean credentialsExpired;
	
	private boolean enabled;
	
	private Collection<UserRole> roles;

	public User(String username, String email) {
		this.username = username;
		this.email = email;
		this.enabled = true;
		this.roles = new ArrayList<>();
	}
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public void addRole(UserRole role) {
		this.roles.add(role);
	}
	
	public void removeRole(UserRole role) {
		this.roles.remove(role);
	}

	@Override
	public void eraseCredentials() {
		this.password = null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return ! accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return ! accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return ! credentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public User copy() {
		User u;
		try {
			u = (User)super.clone();
			u.roles = new ArrayList<>();
			u.roles.addAll(this.roles);
		} catch (CloneNotSupportedException e) {
			throw new Error("Unexpected error, User should be copiable", e);
		}
		
		return u;
	}
}
