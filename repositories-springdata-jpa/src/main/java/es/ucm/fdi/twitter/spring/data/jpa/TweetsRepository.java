package es.ucm.fdi.twitter.spring.data.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.twitter.business.entity.Tweet;

@Repository
public interface TweetsRepository extends es.ucm.fdi.twitter.business.control.TweetsRepository, CrudRepository<Tweet, Long> {

}
