package es.ucm.fdi.twitter.business.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tweet {

	public static final int MAX_LENGTH = 140;

	public static final int MIN_LENGTH = 1;

	@NotNull
	private LocalDateTime date;
	
	@Size(min=1, max=MAX_LENGTH)
	private String message;
	
	@NotNull
	private String username;
	
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
}