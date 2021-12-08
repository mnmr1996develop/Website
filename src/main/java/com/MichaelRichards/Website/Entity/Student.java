package com.MichaelRichards.Website.Entity;

import com.MichaelRichards.Website.Validation.ValidEmail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Collection;
import java.util.Collections;


@Entity
@Table(name = "student")
public class Student extends User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First Name is required")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last Name is required")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Username is required")
    @Column(name = "username")
    private String username;

    @NotNull(message = "Password is required")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Email is required")
    @Column(name = "email")
    @ValidEmail
    private String email;

    @NotNull
    @Column(name = "birthday", columnDefinition = "DATE")
    private Date birthday;

    @NotNull
    @Column(name = "locked")
    private boolean locked;

    @NotNull
    @Column(name = "enabled")
    private boolean enabled;

    @Transient
    private UserRoles userRoles;


    public Student() {
        this.locked = false;
        this.enabled = true;
        this.userRoles = UserRoles.User;
    }

    public Student(String firstName, String lastName, String username, String password, String email, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.locked = false;
        this.enabled = true;
        this.userRoles = UserRoles.User;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", locked=" + locked +
                ", enabled=" + enabled +
                '}';
    }
}