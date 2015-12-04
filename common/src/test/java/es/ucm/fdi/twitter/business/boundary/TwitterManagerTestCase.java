package es.ucm.fdi.twitter.business.boundary;

import static es.eucm.junit.asserts.Exceptions.assertException;
import static es.eucm.junit.asserts.Exceptions.swallowExceptions;
import static es.eucm.junit.matchers.Exceptions.exception;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.internal.stubbing.answers.ReturnsArgumentAt;

import es.ucm.fdi.twitter.business.control.TimeService;
import es.ucm.fdi.twitter.business.control.TweetsRepository;
import es.ucm.fdi.twitter.business.entity.Tweet;

public class TwitterManagerTestCase {

	@Test
	public void properTweetCreation() throws Exception {
		// Given
		TweetsRepository repository = mock(TweetsRepository.class);
		TimeService time = mock(TimeService.class);

		when(repository.save(any(Tweet.class))).thenAnswer(new ReturnsArgumentAt(0));

		TweetsManager manager = new TweetsManager(repository, time);

		// When
		Tweet t = manager.newTweet("Hello", "user");

		// Then
		assertThat(t, not(is(nullValue())));
		verify(repository, times(1)).save(t);
		verify(time, times(1)).now();
	}

	@Test
	public void checkMsgNullThrowsException() throws Exception {
		// Given
		TweetsRepository repository = mock(TweetsRepository.class);
		TimeService time = mock(TimeService.class);

		TweetsManager manager = swallowExceptions(new TweetsManager(repository, time));

		// When
		manager.newTweet(null, "user");

		// Then
		assertException(manager, exception(NullPointerException.class));
	}

	@Test
	public void checkUserNullArgumentThrowsException() throws Exception {
		// Given
		TweetsRepository repository = mock(TweetsRepository.class);
		TimeService time = mock(TimeService.class);

		TweetsManager manager = swallowExceptions(new TweetsManager(repository, time));

		// When
		manager.newTweet("message", null);

		// Then
		assertException(manager, exception(NullPointerException.class));
	}
	
	@Test
	public void checkMsgImproperLength() throws Exception {
		// Given
		TweetsRepository repository = mock(TweetsRepository.class);
		TimeService time = mock(TimeService.class);

		when(repository.save(any(Tweet.class))).thenAnswer(new ReturnsArgumentAt(0));

		TweetsManager manager = swallowExceptions(new TweetsManager(repository, time));

		// When
		int improperLength = 141;
		StringBuilder builder = new StringBuilder(improperLength);
		for(int i = 0; i < improperLength; i++) {
			builder.append('A');
		}
		manager.newTweet(builder.toString(), "user");

		// Then
		assertException(manager, exception(IllegalArgumentException.class));
	}
}
