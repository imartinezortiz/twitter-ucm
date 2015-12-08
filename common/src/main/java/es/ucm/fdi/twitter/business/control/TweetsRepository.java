package es.ucm.fdi.twitter.business.control;

import org.springframework.stereotype.Repository;

import es.ucm.fdi.twitter.business.entity.Tweet;

@Repository
public interface TweetsRepository {

	public Iterable<Tweet> findAll();

	public Tweet save(Tweet newTweet);

}
