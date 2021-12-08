package com.MichaelRichards.Website.Controller;

import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Service.StudentService;
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
    private StudentService studentService;

    @GetMapping("/studentRegistration")
    public String getRegistrationPage(Model model){
        model.addAttribute("student", new Student());
        return "studentRegistration";
    }

    @PostMapping("/processStudentRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result,
            Model model){

        Student findIfStudentInDatabase = studentService.findUserByUsername(student.getUsername()).orElse(null);
        Student findIfEmailInDatabase = studentService.findUserByEmail(student.getEmail()).orElse(null);

        if(findIfStudentInDatabase != null || findIfEmailInDatabase != null){
            if (findIfStudentInDatabase != null){
                model.addAttribute("usernameRegistrationError" , "username already Taken");
            }
            if (findIfEmailInDatabase != null){
                model.addAttribute("emailRegistrationError", "Email is already taken");
            }

            return "studentRegistration";
        }


        if(result.hasErrors()){
            return "studentRegistration";
        }

        studentService.save(student);
        return "index";

    }
}
