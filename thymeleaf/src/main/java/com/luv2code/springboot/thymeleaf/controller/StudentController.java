package com.luv2code.springboot.thymeleaf.controller;

import com.luv2code.springboot.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        //create a student obj
        Student theStudent = new Student();

        // add student obj to the model
        theModel.addAttribute("student", theStudent);

        // add the list of countries to model
        theModel.addAttribute("countries", countries);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.printf("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName() + " "+ theStudent.getCountry());
        return "student-confirmation";
    }



}
