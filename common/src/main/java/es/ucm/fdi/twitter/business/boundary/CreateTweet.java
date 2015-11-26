package es.ucm.fdi.twitter.business.boundary;

import javax.validation.constraints.Size;

import es.ucm.fdi.twitter.business.entity.Tweet;

public class CreateTweet {

	@Size(min=Tweet.MIN_LENGTH, max=Tweet.MAX_LENGTH)
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
