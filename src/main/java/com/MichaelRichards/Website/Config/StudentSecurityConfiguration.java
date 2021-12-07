package com.MichaelRichards.Website.Config;

import com.MichaelRichards.Website.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class StudentSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private StudentService studentService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());

    }


    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setUserDetailsService(studentService);
        provider.setPasswordEncoder(new PasswordEncoderClass().passwordEncoder());
        return provider;
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/processSignInForm")
                .permitAll()
                .and()
                .logout().permitAll();
    }


}