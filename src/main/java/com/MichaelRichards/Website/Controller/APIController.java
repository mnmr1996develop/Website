package com.MichaelRichards.Website.Controller;


import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.Tutor;
import com.MichaelRichards.Website.Entity.User;
import com.MichaelRichards.Website.Exceptions.UserNotFoundException;
import com.MichaelRichards.Website.Service.StudentService;
import com.MichaelRichards.Website.Service.TutorService;
import com.MichaelRichards.Website.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class APIController {

    @Autowired
    StudentService studentService;

    @Autowired
    TutorService tutorService;

    @GetMapping(path = "/students")
    public List<Student> findAllStudents(){
        return studentService.findAll();
    }

//    @GetMapping(path = "/users")
//    public List<User> findAllUsers(){
//        List<User> users = new ArrayList<>(studentService.findAll());
//        users.addAll(tutorService.findAll());
//        return users;
//    }

    @GetMapping(path = "/tutors")
    public List<Tutor> findAllTeachers(){
        return tutorService.findAll();
    }

    @PostMapping(path = "/students")
    public String findAllTeachers(Student student){
        return studentService.save(student);
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        return studentService.findUserById(
                studentId).orElseThrow(
                        () -> new UserNotFoundException("User Not Found - " + studentId));
    }

    @GetMapping("/tutors/{tutorId}")
    public Tutor getTutor(@PathVariable Long tutorId){
        return tutorService.findUserById(
                tutorId).orElseThrow(
                () -> new UserNotFoundException("User Not Found - " + tutorId));
    }

}
