package es.ucm.fdi.twitter.business.control;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class TimeService {

	public LocalDateTime now() {
		return LocalDateTime.now();
	}

}
