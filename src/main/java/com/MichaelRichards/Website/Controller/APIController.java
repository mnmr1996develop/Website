package com.MichaelRichards.Website.Controller;


import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.Teacher;
import com.MichaelRichards.Website.Service.StudentService;
import com.MichaelRichards.Website.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class APIController {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @GetMapping(path = "/student")
    public List<Student> findAllStudents(){
        return studentService.findAll();
    }

    @GetMapping(path = "/teachers")
    public List<Teacher> findAllTeachers(){
        return teacherService.findAll();
    }

    @PostMapping(path = "/students")
    public String findAllTeachers(Student student){
        return studentService.save(student);
    }

}
