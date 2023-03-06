package com.example.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.java.model.User;
import com.example.java.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/user")
	public ModelAndView homePageForUser(ModelAndView modelAndView) {
		List<User> users = userService.getAllUser();
		modelAndView.addObject("USERS_LIST", users);
		modelAndView.setViewName("user");

		return modelAndView;
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/user/edit")
	public ModelAndView editUserPage(@RequestParam("username") String username, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.getUserByUsername(username);

		modelAndView.addObject("user", user);
		modelAndView.setViewName("editUser");

		return modelAndView;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/user/saveUser")
	public ModelAndView saveUser(@ModelAttribute User user, @RequestParam("repassword") String rePassword) {

		ModelAndView modelAndView = new ModelAndView();
		User oldUser = userService.getUserByUsername(user.getUsername());
		if (rePassword != null && !rePassword.isEmpty()) {
			if (!rePassword.equals(user.getPassword())) {
				modelAndView.addObject("password_msg", "Password not Match!");
				modelAndView.setViewName("redirect:/user/edit/" + user.getUsername());
				return modelAndView;
			}
		} else {
			user.setPassword(oldUser.getPassword());
		}
		userService.saveUser(user);
		return new ModelAndView("redirect:/user");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/user/delete/{username}")
	public ModelAndView deleteUser(@PathVariable("userId") String username) {
		ModelAndView modelAndView = new ModelAndView();
		userService.deleteUser(username);
		modelAndView.setViewName("redirect:/user");
		return modelAndView;
	}

}
