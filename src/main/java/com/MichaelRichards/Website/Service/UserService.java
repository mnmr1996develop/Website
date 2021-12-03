package com.MichaelRichards.Website.Service;

import com.MichaelRichards.Website.DAO.UserRepository;
import com.MichaelRichards.Website.Entity.User;
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
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            return new ArrayList<>();
        }
        else return users;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User  user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Could not find a user by that name "));
        System.out.println(user);
        return user;
    }




    public Optional<User> findUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findUserById(long id) throws UsernameNotFoundException{
        return  userRepository.findById(id);
    }

    public Optional<User> findUserByEmail(String email) throws UsernameNotFoundException{
        return userRepository.findByEmail(email);
    }



    @Transactional
    public String save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        String token = UUID.randomUUID().toString();

        System.out.println(user);
        userRepository.save(user);

        return token;
    }
}
