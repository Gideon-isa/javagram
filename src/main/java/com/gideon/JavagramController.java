package com.gideon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class JavagramController {
    
    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @GetMapping("/result")
    public String getResult(Model model) {
        //model.addAttribute(null, model)
        return "result";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            
            if (user.getFirstName().equals(user.getLastName())) {
                bindingResult.rejectValue("lastName", "", null, "please enter valid");
            }
            
            return "sign-up";
        }
        // if (user.getFirstName().equals(user.getLastName())) {
        //     bindingResult.rejectValue("lastName", "", null, "please enter valid");
        //     return "sign-up";
        // }
        
        return "redirect:/result";
    }
}
