package com.MichaelRichards.Website.Service;

import com.MichaelRichards.Website.DAO.TutorRepository;
import com.MichaelRichards.Website.Entity.Tutor;
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
    TutorRepository tutorRepository;

    public List<Tutor> findAll(){
        List<Tutor> tutors = tutorRepository.findAll();
        if (tutors.isEmpty()){
            return new ArrayList<>();
        }
        else return tutors;
    }

    @Transactional
    public String save(Tutor tutor){
        tutor.setPassword(passwordEncoder.encode(tutor.getPassword()));

        String token = UUID.randomUUID().toString();

        System.out.println(tutor);
        tutorRepository.save(tutor);

        return token;
    }
}
