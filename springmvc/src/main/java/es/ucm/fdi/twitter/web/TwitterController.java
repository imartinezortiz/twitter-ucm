package es.ucm.fdi.twitter.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.twitter.business.boundary.CreateTweet;
import es.ucm.fdi.twitter.business.boundary.TweetsManager;
import es.ucm.fdi.users.business.boundary.UsersManager;

@Controller
@RequestMapping("/tweets")
public class TwitterController {

	private TweetsManager tweets;

	private UsersManager usuarios;

	@Autowired
	public TwitterController(TweetsManager tweets, UsersManager usuarios) {
		this.tweets = tweets;
		this.usuarios = usuarios;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getTweets() {
		Map<String, Object> model = new HashMap<>();
		model.put("tweets", this.tweets.getTweets());
		model.put("createTweet", new CreateTweet());
		return new ModelAndView("tweets", model);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addTweet(@ModelAttribute("createTweet") @Valid CreateTweet tweetForm, BindingResult errors) {
		ModelAndView view = null;
		if (errors.hasErrors()) {
			view = new ModelAndView("tweets");
			view.addObject("tweets", this.tweets.getTweets());
		} else {
			tweets.newTweet(tweetForm.getMessage(), usuarios.getCurrentUser().getUsername());
			view = new ModelAndView("redirect:/tweets");
		}
		return view;
	}
}
