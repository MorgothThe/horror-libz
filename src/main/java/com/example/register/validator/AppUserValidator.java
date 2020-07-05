package com.example.register.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.register.dao.AppUserDAO;
import com.example.register.formbean.AppUserForm;
import com.example.register.model.AppUser;
 
@Component
public class AppUserValidator implements Validator {
    // common-validator library.
    private EmailValidator emailValidator = EmailValidator.getInstance(); 
    @Autowired
    private AppUserDAO appUserDAO;
    // The classes are supported by this validator.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == AppUserForm.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        AppUserForm appUserForm = (AppUserForm) target;
 
        // Check the fields of AppUserForm.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.appUserForm.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.appUserForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.appUserForm.confirmPassword");
 
        if (!this.emailValidator.isValid(appUserForm.getEmail())) {
            // Invalid email.
            errors.rejectValue("email", "Pattern.appUserForm.email");
        } else if (appUserForm.getUserId() == null) {
            AppUser dbUser = appUserDAO.findAppUserByEmail(appUserForm.getEmail());
            if (dbUser != null) {
                // Email has been used by another account.
                errors.rejectValue("email", "Duplicate.appUserForm.email");
            }
        }
 
        if (!errors.hasFieldErrors("username")) {
            AppUser dbUser = appUserDAO.findAppUserByUsername(appUserForm.getUsername());
            if (dbUser != null) {
                // Username is not available.
                errors.rejectValue("username", "Duplicate.appUserForm.username");
            }
        }
 
        if (!errors.hasErrors()) {
            if (!appUserForm.getConfirmPassword().equals(appUserForm.getPassword())) {
                errors.rejectValue("confirmPassword", "Match.appUserForm.confirmPassword");
            }
        }
    }
 
}