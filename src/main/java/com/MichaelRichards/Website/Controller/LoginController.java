package com.MichaelRichards.Website.Controller;

import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.Tutor;
import com.MichaelRichards.Website.Entity.User;
import com.MichaelRichards.Website.Service.StudentService;
import com.MichaelRichards.Website.Service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class LoginController {

    public LoginController() {
    }

    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    public LoginController(UserBaseService userBaseService){
        this.userBaseService = userBaseService;
    }


    @GetMapping("/login")
    public String getStudentLoginPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            model.addAttribute("user", new User());
            return "login";
        }

        return "redirect:/";
    }




}
