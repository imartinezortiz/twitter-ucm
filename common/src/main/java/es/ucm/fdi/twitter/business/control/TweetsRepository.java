package es.ucm.fdi.twitter.business.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.ucm.fdi.twitter.business.entity.Tweet;

@Repository
public class TweetsRepository {

	private List<Tweet> tweets;
	
	public TweetsRepository() {
		this.tweets = new ArrayList<>();
	}
	
	public List<Tweet> getTweets() {
		return tweets;
	}

	public Tweet addTweet(Tweet newTweet) {
		Tweet t = new Tweet(newTweet.getDate(), newTweet.getMessage(), newTweet.getUsername());
		tweets.add(t);
		return newTweet;
	}

}
