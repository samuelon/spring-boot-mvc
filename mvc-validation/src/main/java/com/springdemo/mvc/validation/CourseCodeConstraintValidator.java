package com.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
    implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        //html form data entered by user, additional error messages here
        //useful to talk to db,number crunching, call api, etc.
        //custom business logic here
        boolean result;
        if ( theCode != null){
            result = theCode.startsWith(coursePrefix);
        } else {
            result = true; // didn't pass, nothing to valid.
        }
        return result;
    }


}
