package es.ucm.fdi.twitter.business.boundary;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ucm.fdi.twitter.business.control.TimeService;
import es.ucm.fdi.twitter.business.control.TweetsRepository;
import es.ucm.fdi.twitter.business.entity.Tweet;

@Service
public class TweetsManager {

	private TweetsRepository repo;

	private TimeService time;


	protected TweetsManager() {
		
	}
	
	@Autowired
	public TweetsManager(TweetsRepository repositorio, TimeService time) {
		this.repo = repositorio;
		this.time = time;
	}

	@Transactional(readOnly=true)
	public Iterable<Tweet> getTweets() {
		return this.repo.findAll();
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@Transactional(readOnly=false)
	public Tweet newTweet(String msg, String username) {
		checkNotNull(msg, "msg can not be null");
		checkNotNull(username, "username can not be null");
		checkArgument(msg.length() >= Tweet.MIN_LENGTH && msg.length() <= Tweet.MAX_LENGTH,
				"msg length must be between 0 and %i: actual length is %i", Tweet.MAX_LENGTH, msg.length());

		Tweet newTweet = new Tweet(time.now(), msg, username);
		return this.repo.save(newTweet);
	}
}
