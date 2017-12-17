package com.gestion.marchant.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.marchant.entities.role;
import com.gestion.marchant.entities.utilisateur;
import com.gestion.marchant.metier.IAdmin;
import com.gestion.marchant.passwordMatchValidator.userValidator;

@Controller
public class loginController {
	@Autowired
	IAdmin metier;
	@Autowired
	userValidator userVal;
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");

	  return model;	
	}
	@RequestMapping(value = "/signIn")
	public String signIn(@Valid utilisateur u,BindingResult binding,Model model,role r) {
		userVal.validate(u, binding);
		if(binding.hasErrors()){			
			return "signIn";
		}
		
		u.setActivated(true);
		metier.ajouterUtilisateur(u);
		metier.attribuerRole(new role("ROLE_USER"), u.getIdUtilisateur());
	    model.addAttribute("utilisateur", new utilisateur());
//		model.addAttribute("msg", "You've been signed in successfully.");
	  return "signIn";	
}
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();

	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		model.addObject("username", userDetail.getUsername());
	  }

	  model.setViewName("403");
	  return model;

	}
	@RequestMapping(value = "/signInPage")
	public String signInpage(Model model) {
	    model.addAttribute("utilisateur", new utilisateur());
	  return "signIn";	
}
	@RequestMapping(value="/toLogin")
	public String tologin(){
		return "login";
	}
}
