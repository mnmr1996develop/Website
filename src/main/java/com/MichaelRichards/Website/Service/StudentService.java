package com.MichaelRichards.Website.Service;

import com.MichaelRichards.Website.DAO.StudentRepository;
import com.MichaelRichards.Website.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public List<Student> findAll(){
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()){
            return new ArrayList<>();
        }
        else return students;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Could not find a student by that name "));
        return student;
    }




    public Optional<Student> findUserByUsername(String username) throws UsernameNotFoundException {
        return studentRepository.findByUsername(username);
    }

    public Optional<Student> findUserById(long id) throws UsernameNotFoundException{
        return  studentRepository.findById(id);
    }

    public Optional<Student> findUserByEmail(String email) throws UsernameNotFoundException{
        return studentRepository.findByEmail(email);
    }



    @Transactional
    public String save(Student student){
        student.setPassword(passwordEncoder.encode(student.getPassword()));

        String token = UUID.randomUUID().toString();

        System.out.println(student);
        studentRepository.save(student);

        return token;
    }
}
