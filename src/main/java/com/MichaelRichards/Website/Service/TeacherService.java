package com.MichaelRichards.Website.Service;

import com.MichaelRichards.Website.DAO.TeacherRepository;
import com.MichaelRichards.Website.DAO.UserRepository;
import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> findAll(){
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty()){
            return new ArrayList<>();
        }
        else return teachers;
    }

    @Transactional
    public String save(Teacher teacher){
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));

        String token = UUID.randomUUID().toString();

        System.out.println(teacher);
        teacherRepository.save(teacher);

        return token;
    }
}
