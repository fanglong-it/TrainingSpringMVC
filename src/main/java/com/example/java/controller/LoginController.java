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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

//	@RequestMapping(value = "/postLogin")
//	public void postLogin(Model model, HttpSession session) {
//		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder
//				.getContext().getAuthentication();
//		validatePrinciple(authentication.getPrincipal());
//
//		User loggedInUser = ((UserDetailsDTO) authentication.getPrincipal()).getUserDetails();
//		model.addAttribute("currentUser", loggedInUser.getUsername());
//		session.setAttribute("userId", loggedInUser.getUsername());
//	}
//
//	private void validatePrinciple(Object principal) {
//		if (!(principal instanceof UserDetailsDTO)) {
//			throw new IllegalArgumentException("Principal can not be null!");
//		}
//	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView home() {

//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if(auth != null) {
//			Object principal = auth.getPrincipal();
//			if()
//		}

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

}
