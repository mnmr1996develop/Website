package com.MichaelRichards.Website.Config;


import com.MichaelRichards.Website.Entity.UserRoles;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
@Order(0)
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {

    UserSecurityConfiguration(){
        super();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .formLogin()
                .loginPage("/studentLogin")
                .loginProcessingUrl("/processStudentSignInForm")
                .permitAll()
                .and()
                .logout().permitAll();
    }


}