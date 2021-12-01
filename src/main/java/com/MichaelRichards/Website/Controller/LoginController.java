package com.MichaelRichards.Website.Controller;

import com.MichaelRichards.Website.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

}
