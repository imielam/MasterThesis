package com.maciej.imiela.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.maciej.imiela.repository.LoginRepository;

public class UniqueLoginEmailValidator implements
ConstraintValidator<UniqueLoginEmail, String> {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public void initialize(UniqueLoginEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (this.loginRepository == null) {
            return true;
        }
        return this.loginRepository.findByEmail(email) == null;
    }

}
