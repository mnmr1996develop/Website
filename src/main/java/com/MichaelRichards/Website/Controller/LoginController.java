package com.MichaelRichards.Website.Controller;

import com.MichaelRichards.Website.Entity.User;
import com.MichaelRichards.Website.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;

@Controller
@RequestMapping
public class LoginController {

    public LoginController() {
    }

    @Autowired
    private UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }


}
