package com.MichaelRichards.Website.Controller;

import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Service.StudentService;
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
    private StudentService studentService;

    @Autowired
    public LoginController(StudentService studentService){
        this.studentService = studentService;
    }


    @GetMapping("/login")
    public String getLoginPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            model.addAttribute("user", new Student());
            return "login";
        }

        return "redirect:/";
    }




}
