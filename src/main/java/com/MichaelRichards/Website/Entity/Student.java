package com.MichaelRichards.Website.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "student")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student extends User {


    @NotNull
    @Column(name = "locked")
    private boolean locked;

    @NotNull
    @Column(name = "enabled")
    private boolean enabled;

    @Transient
    @Enumerated(value = EnumType.STRING)
    private UserRoles userRoles;




    public Student() {
        super();
        this.locked = false;
        this.enabled = true;
        this.userRoles = UserRoles.User;
    }

    public Student(String firstName, String lastName, String username, String password, String email, LocalDate birthday) {
        super(firstName, lastName, username, password, email, birthday);
        this.locked = false;
        this.enabled = true;
        this.userRoles = UserRoles.User;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public UserRoles getUserRoles() {
        return userRoles;
    }

    @Override
    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

}
