package com.example.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.java.model.User;

//@SessionAttributes({ "currentUser" })
@Controller
public class LoginController {

	private static final Logger logger = LogManager.getLogger("LoginController");

	@RequestMapping(value = "/dang-nhap")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			logger.error(error);
			if (error.equals("failed")) {
				model.addAttribute("error", "Username of Password is Incorrect!");
			}
		}
		return "login";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("homePage");
		return modelAndView;
	}

	@RequestMapping("/dang-xuat")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/dang-nhap";
	}

	@RequestMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}

	@RequestMapping("/dang-ky")
	public ModelAndView register(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editUser");
		User user = new User();
		modelAndView.addObject("user", user);
		return modelAndView;
	}

}
