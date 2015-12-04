package es.ucm.fdi.twitter.business.control;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.ucm.fdi.twitter.business.entity.Tweet;

@Repository
public interface TweetsRepository extends CrudRepository<Tweet, Long> {

}
