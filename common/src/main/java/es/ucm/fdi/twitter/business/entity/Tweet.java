package es.ucm.fdi.twitter.business.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Tweets")
public class Tweet implements Cloneable {

	public static final int MAX_LENGTH = 140;

	public static final int MIN_LENGTH = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private LocalDateTime date;
	
	@Size(min=1, max=MAX_LENGTH)
	private String message;
	
	@NotNull
	private String username;
	
	Tweet() {
		
	}
	
	public Tweet(LocalDateTime date, String message, String username) {
		this.date = date;
		this.message = message;
		this.username = username;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}

	public String getUsername() {
		return username;
	}
	
	public Tweet copy() {
		Tweet t;
		try {
			t = (Tweet)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error("Unexpected error, User should be copiable", e);
		}
		
		return t;
	}
}