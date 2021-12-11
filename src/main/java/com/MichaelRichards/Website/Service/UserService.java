package com.MichaelRichards.Website.Service;


import com.MichaelRichards.Website.DAO.UserRepository;
import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;



public abstract class UserService<T extends User, K extends UserRepository<T>>  {


    @Autowired
    private K userRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    public List<T> findAll(){
        List<T> users = userRepository.findAll();
        if (users.isEmpty()){
            return new ArrayList<>();
        }
        else return users;
    }

    @Transactional
    public String save(T user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String token = UUID.randomUUID().toString();
        System.out.println(user);
        userRepository.save(user);
        return token;
    }

    public Optional<T> findUserById(long id) throws UsernameNotFoundException{
        return  userRepository.findById(id);
    }

    public Optional<T> findUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public Optional<T> findUserByEmail(String email) throws UsernameNotFoundException{
        return userRepository.findByEmail(email);
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        T user;
//        user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No User by that name"));
//        return user;
//    }


}
