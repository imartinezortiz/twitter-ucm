package es.ucm.fdi.twitter.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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

	@SuppressWarnings("unchecked")
	@Override
	public <S extends Tweet> S save(S entity) {
		S result = (S) entity.copy();
		entities.put(this.idGenerator++, result);
		return result;
	}

	@Override
	public <S extends Tweet> Iterable<S> save(Iterable<S> entities) {
		final Collection<S> result = new ArrayList<>();
		for(S e : entities) {
			result.add(save(e));
		}
		return new Iterable<S>() {
			@Override
			public Iterator<S> iterator() {
				return result.iterator();
			}
			
		};
	}

	@Override
	public Tweet findOne(Long id) {
		Tweet tweet = entities.get(id).copy();
		return tweet;
	}

	@Override
	public boolean exists(Long id) {
		return this.entities.containsKey(id);
	}

	@Override
	public Iterable<Tweet> findAll() {
		Collection<Tweet> result = new LinkedList<>();
		result.addAll(this.entities.values());
		return result;
	}

	@Override
	public Iterable<Tweet> findAll(Iterable<Long> ids) {
		Collection<Tweet> result = new LinkedList<>();
		for (Long id : ids) {
			if (this.entities.containsKey(id)) {
				result.add(this.entities.get(id));
			}
		}
		return result;
	}

	@Override
	public long count() {
		return this.entities.size();
	}

	@Override
	public void delete(Long id) {
		this.entities.remove(id);
	}

	@Override
	public void delete(Tweet entity) {
		for (Map.Entry<Long, Tweet> e : this.entities.entrySet()) {
			if (e.getValue().equals(entity)) {
				this.entities.remove(e.getKey());
				break;
			}
		}
	}

	@Override
	public void delete(Iterable<? extends Tweet> entities) {
		for (Tweet entity : entities) {
			for (Map.Entry<Long, Tweet> e : this.entities.entrySet()) {
				if (e.getValue().equals(entity)) {
					this.entities.remove(e.getKey());
					break;
				}
			}
		}
	}

	@Override
	public void deleteAll() {
		this.entities.clear();
	}
}