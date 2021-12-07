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
@Table(name = "user")
public class Student implements UserDetails {

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




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("userRoles.name()");
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
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
