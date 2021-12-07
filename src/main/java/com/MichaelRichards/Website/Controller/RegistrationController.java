package com.MichaelRichards.Website.Controller;

import com.MichaelRichards.Website.Entity.User;
import com.MichaelRichards.Website.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Model model){

        User findIfUserInDatabase = userService.findUserByUsername(user.getUsername()).orElse(null);
        User findIfEmailInDatabase = userService.findUserByEmail(user.getEmail()).orElse(null);

        if(findIfUserInDatabase != null || findIfEmailInDatabase != null){
            if (findIfUserInDatabase != null){
                model.addAttribute("usernameRegistrationError" , "User name already Taken");
            }
            if (findIfEmailInDatabase != null){
                model.addAttribute("emailRegistrationError", "Email is already taken");
            }

            return "register";
        }


        if(result.hasErrors()){
            return "register";
        }

        userService.save(user);
        return "index";

    }
}
