package com.MichaelRichards.Website.Service;


import com.MichaelRichards.Website.DAO.StudentRepository;
import com.MichaelRichards.Website.Entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends UserService<Student, StudentRepository>{
}
