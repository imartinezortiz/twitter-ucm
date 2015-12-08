package es.ucm.fdi.twitter.spring.orm.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import es.ucm.fdi.twitter.business.entity.Tweet;

@Repository
public class TweetsRepository implements es.ucm.fdi.twitter.business.control.TweetsRepository {

	@PersistenceContext
	private EntityManager em;


	@Override
	public Iterable<Tweet> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Tweet> q = cb.createQuery(Tweet.class);
		Root<Tweet> c = q.from(Tweet.class);

		return em.createQuery(q).getResultList();
	}

	@Override
	public Tweet save(Tweet newTweet) {
		return em.merge(newTweet);
	}

}
