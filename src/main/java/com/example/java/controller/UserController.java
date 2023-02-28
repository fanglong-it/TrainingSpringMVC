package com.example.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.java.dao.UserDAO;
import com.example.java.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	
	@RequestMapping("/user")
	public ModelAndView homePageForUser(ModelAndView modelAndView) {
		List<User> users = userDAO.list();
		modelAndView.addObject("USERS_LIST", users);
		modelAndView.setViewName("user");
		
		return modelAndView;
	}
	
	@RequestMapping("/user/edit/{userId}")
	public ModelAndView editUserPage(@PathVariable("userId") int userId, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		User user = userDAO.get(userId);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("editUser");
		
		return modelAndView;
	}
	
	@RequestMapping("/user/saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		userDAO.saveOrUpdate(user);
		return new ModelAndView("redirect:/");
	}
	
	
	
	
}
