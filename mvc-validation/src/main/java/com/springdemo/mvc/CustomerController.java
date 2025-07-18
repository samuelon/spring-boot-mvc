package com.springdemo.mvc;



import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm( Model theModel) {


        theModel.addAttribute("customer", new Customer());


        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult) {
        //@Valid uses the @NotNull validation.~~
        //Binding Result is result of the validation
        System.out.println("Binding result: "+ theBindingResult.toString());
        System.out.println("\n\n\n");
        if (theBindingResult.hasErrors()){
            return "customer-form";
        } else {
            System.out.println("Last name: |" + theCustomer.getLastName());
            return "customer-confirmation";
        }
    }

    @InitBinder //pre process any web request
    public void initBinder(WebDataBinder dataBinder){
        //remove leading and trailing white spaces
        //resolve issue for our validation

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }



}
