package com.maciej.imiela.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.maciej.imiela.repository.LoginRepository;

public class UniqueLoginLoginValidator implements
ConstraintValidator<UniqueLoginLogin, String> {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public void initialize(UniqueLoginLogin constraintAnnotation) {
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext context) {
        if (this.loginRepository == null) {
            return true;
        }
        return this.loginRepository.findByLogin(login) == null;
    }

}
