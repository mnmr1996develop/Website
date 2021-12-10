package com.MichaelRichards.Website.Service;

import com.MichaelRichards.Website.DAO.StudentRepository;
import com.MichaelRichards.Website.DAO.TutorRepository;
import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Objects;



@Service
public class UserService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TutorRepository tutorRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student = studentRepository.findByUsername(username).orElse(null);
        Tutor tutor = tutorRepository.findByUsername(username).orElse(null);

        if(student == null && tutor == null){
            throw new UsernameNotFoundException("No user by that name");
        }
        else return Objects.requireNonNullElse(student, tutor);
    }

}
