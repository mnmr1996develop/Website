package com.MichaelRichards.Website.Controller;

import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.Tutor;
import com.MichaelRichards.Website.Service.StudentService;
import com.MichaelRichards.Website.Service.TutorService;
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
    private StudentService studentService;
    
    @Autowired
    private TutorService tutorService;

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

        Student findIfStudentUsernameInDatabase = studentService.findUserByUsername(student.getUsername()).orElse(null);
        Student findIfStudentEmailInDatabase = studentService.findUserByEmail(student.getEmail()).orElse(null);

        Tutor findIfTutorUsernameInDatabase = tutorService.findUserByUsername(student.getUsername()).orElse(null);
        Tutor findIfTutorEmailInDatabase = tutorService.findUserByEmail(student.getEmail()).orElse(null);

        if(findIfStudentUsernameInDatabase != null || findIfStudentEmailInDatabase != null ||
                findIfTutorUsernameInDatabase != null || findIfTutorEmailInDatabase != null){
            if (findIfStudentUsernameInDatabase != null || findIfTutorUsernameInDatabase != null){
                model.addAttribute("usernameRegistrationError" , "username already Taken");
            }
            if (findIfStudentEmailInDatabase != null){
                model.addAttribute("emailRegistrationError", "Email is already taken");
            }

            return "studentRegistration";
        }


        if(result.hasErrors()){
            return "studentRegistration";
        }

        studentService.save(student);
        return "redirect:/login";

    }

    @PostMapping("/processTutorRegistrationForm")
    public String processTutorRegistrationForm(
            @Valid @ModelAttribute("tutor") Tutor tutor,
            BindingResult result,
            Model model){

        Student findIfStudentUsernameInDatabase = studentService.findUserByUsername(tutor.getUsername()).orElse(null);
        Student findIfStudentEmailInDatabase = studentService.findUserByEmail(tutor.getEmail()).orElse(null);

        Tutor findIfTutorUsernameInDatabase = tutorService.findUserByUsername(tutor.getUsername()).orElse(null);
        Tutor findIfTutorEmailInDatabase = tutorService.findUserByEmail(tutor.getEmail()).orElse(null);

        if(findIfStudentUsernameInDatabase != null || findIfStudentEmailInDatabase != null ||
                findIfTutorUsernameInDatabase != null || findIfTutorEmailInDatabase != null){
            if (findIfStudentUsernameInDatabase != null || findIfTutorUsernameInDatabase != null){
                model.addAttribute("usernameRegistrationError" , "username already Taken");
            }
            if (findIfStudentEmailInDatabase != null){
                model.addAttribute("emailRegistrationError", "Email is already taken");
            }

            return "studentRegistration";
        }


        if(result.hasErrors()){
            return "studentRegistration";
        }

        tutorService.save(tutor);
        return "redirect:/login";

    }
}
