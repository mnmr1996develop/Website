package com.MichaelRichards.Website.Service;

import com.MichaelRichards.Website.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserBaseService implements UserDetailsService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TutorService tutorService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = studentService.findUserByUsername(username).orElse(null);
        if (user == null){
            user = tutorService.findUserByUsername(username).orElse(null);
        }

        if(user == null){
            throw new UsernameNotFoundException("No User by that name");
        }

        return user;
    }

    public boolean isEmailTaken (String email) throws UsernameNotFoundException{
        boolean isEmailTaken = false;
       if( studentService.findUserByEmail(email).isPresent() ||
               tutorService.findUserByEmail(email).isPresent()){
           isEmailTaken = true;
       }


        return isEmailTaken;
    }

    public boolean isUsernameTaken(String username) throws UsernameNotFoundException {
        boolean isUsernameTake = false;

        if( studentService.findUserByUsername(username).isPresent() ||
                tutorService.findUserByUsername(username).isPresent()){
            isUsernameTake = true;
        }

        return isUsernameTake;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public TutorService getTutorService() {
        return tutorService;
    }
}
