package es.ucm.fdi.users.business.boundary;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import es.ucm.fdi.users.business.entity.User;

public class CreateUser {

	@Size(min=User.USERNAME_MIN_LENGTH, max=User.USERNAME_MAX_LENGTH)
	private String username;
	
	@Size(min=User.PASSWORD_MIN_LENGTH, max=User.PASSWORD_MAX_LENGTH)
	private String password;
	
	@Email
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
