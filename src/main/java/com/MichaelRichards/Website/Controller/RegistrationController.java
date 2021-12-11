package com.MichaelRichards.Website.Controller;

import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.Tutor;
import com.MichaelRichards.Website.Entity.User;
import com.MichaelRichards.Website.Service.StudentService;
import com.MichaelRichards.Website.Service.TutorService;
import com.MichaelRichards.Website.Service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping(path = "/register")
public class RegistrationController {


    @Autowired
    private UserBaseService userBaseService;


    @GetMapping("/student")
    public String getRegistrationPage(Model model){
        model.addAttribute("student", new Student());
        return "studentRegistration";
    }

    @GetMapping("/tutor")
    public String getTutorRegistrationPage(Model model){
        model.addAttribute("tutor", new Tutor());
        return "tutorRegistration";
    }

    @PostMapping("/processStudentRegistrationForm")
    public String processStudentRegistrationForm(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result,
            Model model){

        String userDetailsTaken = areUserDetailsTaken(student, model,"studentRegistration");
        if(userDetailsTaken != null){
            return userDetailsTaken;
        }

        if(result.hasErrors()){
            return "studentRegistration";
        }

        userBaseService.getStudentService().save(student);
        return "redirect:/login";

    }

    @PostMapping("/processTutorRegistrationForm")
    public String processTutorRegistrationForm(
            @Valid @ModelAttribute("tutor") Tutor tutor,
            BindingResult result,
            Model model){

        String userDetailsTaken = areUserDetailsTaken(tutor, model, "tutorRegistration");
        if(userDetailsTaken != null){
            return userDetailsTaken;
        }

        if(result.hasErrors()){
            return "studentRegistration";
        }

        userBaseService.getTutorService().save(tutor);
        return "redirect:/login";

    }


    private String areUserDetailsTaken(User user, Model model, String redirectSite){
        boolean isEmailTaken = userBaseService.isEmailTaken(user.getEmail());
        boolean isUsernameTaken = userBaseService.isUsernameTaken(user.getUsername());

        if(isUsernameTaken){
            model.addAttribute("usernameRegistrationError" , "username already Taken");
        }

        if(isEmailTaken){
            model.addAttribute("emailRegistrationError", "Email is already taken");
        }

        if(isEmailTaken|| isUsernameTaken){
            return redirectSite;
        }

        return null;
    }



}
