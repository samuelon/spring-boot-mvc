package com.luv2code.springboot.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // new controller method to show initial HTML form


    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping(path="/processForm", method= RequestMethod.GET)
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(
            HttpServletRequest request, Model theModel){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        //convert the data to all caps
        theName = theName.toUpperCase();
        //create the message
        StringBuilder result = new StringBuilder("Yo! " + theName);

        // add message to the model
        theModel.addAttribute("message", result.toString());

        return "helloworld";
    }
    //new method
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName, Model theModel){
        // read the request parameter from the HTML form and bind to theName;
        //convert the data to all caps
        theName = theName.toUpperCase();
        //create the message
        StringBuilder result = new StringBuilder("Hey My Friend! " + theName);

        // add message to the model
        theModel.addAttribute("message", result.toString());

        return "helloworld";
    }
}
