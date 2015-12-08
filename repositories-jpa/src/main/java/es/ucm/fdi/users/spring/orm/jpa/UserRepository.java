package es.ucm.fdi.users.spring.orm.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.users.business.entity.User;
import es.ucm.fdi.users.business.entity.User_;

@Repository
public class UserRepository implements es.ucm.fdi.users.business.control.UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserDetails findByEmail(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> q = cb.createQuery(User.class);

		Root<User> userNode = q.from(User.class);
		q.where(cb.equal(userNode.get(User_.email), username));
		
		List<User> results = em.createQuery(q).getResultList();
    if (results.isEmpty()) {
    	return null;
    } else if (results.size() == 1) {
    	return results.get(0);
    }
    throw new NonUniqueResultException();
	}

	@Override
	public UserDetails findByUsername(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> q = cb.createQuery(User.class);

		Root<User> userNode = q.from(User.class);
		q.where(cb.equal(userNode.get(User_.username), username));

		List<User> results = em.createQuery(q).getResultList();
    if (results.isEmpty()) {
    	return null;
    } else if (results.size() == 1) {
    	return results.get(0);
    }
    throw new NonUniqueResultException();
	}

	@Override
	public User findOne(Long idUsuario) {
		return em.find(User.class, idUsuario);
	}

	@Override
	public User save(User user) {
		return em.merge(user);
	}
}
