package es.ucm.fdi.users.business.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="USER")
public class User  implements UserDetails, CredentialsContainer, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int USERNAME_MAX_LENGTH = 20;

	public static final int USERNAME_MIN_LENGTH = 5;

	public static final int PASSWORD_MIN_LENGTH = 5;

	public static final int PASSWORD_MAX_LENGTH = 30;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long id;
	
	@Column(unique=true)
	private String username;
	
	@Column(unique=true)
	@Email
	private String email;
	
	private String password;
	
	private boolean accountExpired;
	
	private boolean accountLocked;
	
	private boolean credentialsExpired;
	
	private boolean enabled;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="USER_ROLES", joinColumns=@JoinColumn(name="user"),  uniqueConstraints=@UniqueConstraint(columnNames={"user", "role"}))
	private Collection<UserRole> roles;

	User() {
		
	}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
