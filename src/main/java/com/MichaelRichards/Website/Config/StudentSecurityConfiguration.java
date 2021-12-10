package com.MichaelRichards.Website.Config;

import com.MichaelRichards.Website.Service.StudentService;
import com.MichaelRichards.Website.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class StudentSecurityConfiguration  extends WebSecurityConfigurerAdapter {

    StudentSecurityConfiguration(){
        super();
    }


    @Autowired
    private UserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoStudentAuthenticationProvider());

    }

    @Bean
    DaoAuthenticationProvider daoStudentAuthenticationProvider(){
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(new PasswordEncoderClass().passwordEncoder());
        return provider;
    }
}
