package es.ucm.fdi.users.web;

import static org.springframework.web.util.UriComponentsBuilder.fromPath;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.ucm.fdi.users.business.boundary.CreateUser;
import es.ucm.fdi.users.business.boundary.UsersManager;
import es.ucm.fdi.users.business.entity.User;

@Controller
public class UsersManagementController {

	private UsersManager usersManager;

	@Autowired
	public UsersManagementController(UsersManager usersManager) {
		this.usersManager = usersManager;
	}
	
	@RequestMapping(path="/users/registration", method=RequestMethod.GET)
	public ModelAndView showRegistrationForm(@RequestParam(name="success", required=false, defaultValue="false") boolean success, @RequestParam(name="username", required=false) String username) {
		ModelAndView view = null;
		if (success) {
			view = new ModelAndView("userRegistrationCompleted");
			view.addObject("username", username);
		} else {
  		view = new ModelAndView("userRegistration");
  		view.addObject("createUser", new CreateUser());
		}
		return view;
	}
	
	@RequestMapping(path="/users", method=RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("createUser") @Valid CreateUser newUser, BindingResult errors) {
		ModelAndView view = null;
		if (errors.hasErrors()) {
			view = new ModelAndView("userRegistration");
		} else {
			User user = usersManager.createUser(newUser);
			view = new ModelAndView(fromPath("/users/registration").scheme("redirect").queryParam("username", user.getUsername()).queryParam("success", "true").build().toUriString());
		}

		return view;
	}
}
