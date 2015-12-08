package es.ucm.fdi.twitter.business.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tweet.class)
public abstract class Tweet_ {

	public static volatile SingularAttribute<Tweet, LocalDateTime> date;
	public static volatile SingularAttribute<Tweet, Long> id;
	public static volatile SingularAttribute<Tweet, String> message;
	public static volatile SingularAttribute<Tweet, String> username;

}

