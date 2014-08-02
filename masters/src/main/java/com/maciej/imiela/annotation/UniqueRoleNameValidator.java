package com.maciej.imiela.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.maciej.imiela.repository.RoleRepository;

public class UniqueRoleNameValidator implements
ConstraintValidator<UniqueRoleName, String> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void initialize(UniqueRoleName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (this.roleRepository == null) {
            return true;
        }
        return this.roleRepository.findByName(name) == null;
    }

}
