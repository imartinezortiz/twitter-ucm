package es.ucm.fdi.twitter.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.stereotype.Repository;

import es.ucm.fdi.twitter.business.entity.Tweet;

@Repository
public class TweetsRepository implements es.ucm.fdi.twitter.business.control.TweetsRepository {

	private Map<Long, Tweet> entities;

	private long idGenerator;

	public TweetsRepository() {
		this.entities = new HashMap<>();
	}

	@Override
	public Tweet save(Tweet entity) {
		Tweet result = entity.copy();
		entities.put(this.idGenerator++, result);
		return result;
	}

	@Override
	public Iterable<Tweet> findAll() {
		Collection<Tweet> result = new LinkedList<>();
		result.addAll(this.entities.values());
		return result;
	}
}