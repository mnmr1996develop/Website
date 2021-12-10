package com.MichaelRichards.Website.Controller;


import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.Tutor;
import com.MichaelRichards.Website.Entity.User;
import com.MichaelRichards.Website.Service.StudentService;
import com.MichaelRichards.Website.Service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class APIController {

    @Autowired
    StudentService studentService;

    @Autowired
    TutorService tutorService;

    @GetMapping(path = "/student")
    public List<Student> findAllStudents(){
        return studentService.findAll();
    }

    @GetMapping(path = "/users")
    public List<User> findAllUsers(){
        List<User> users = new ArrayList<>(studentService.findAll());
        users.addAll(tutorService.findAll());
        return users;
    }

    @GetMapping(path = "/tutors")
    public List<Tutor> findAllTeachers(){
        return tutorService.findAll();
    }

    @PostMapping(path = "/student")
    public String findAllTeachers(Student student){
        return studentService.save(student);
    }

}
