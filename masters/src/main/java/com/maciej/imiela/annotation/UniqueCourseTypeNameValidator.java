package com.maciej.imiela.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.maciej.imiela.repository.CourseTypeRepository;

public class UniqueCourseTypeNameValidator implements
        ConstraintValidator<UniqueCourseTypeName, String> {

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Override
    public void initialize(UniqueCourseTypeName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (this.courseTypeRepository == null) {
            return true;
        }
        return this.courseTypeRepository.findByName(name) == null;
    }

}
