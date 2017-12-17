package com.gestion.marchant.passwordMatchValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gestion.marchant.entities.utilisateur;
@Component
public class userValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		  return utilisateur.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		utilisateur u=(utilisateur) target;
		String password=u.getPassword();
		String confirmPassword=u.getConfirmPassword();
		if(!password.equals(confirmPassword)){
			errors.rejectValue("password", "utilisateur.password.missMatch");
		}
	}

}
