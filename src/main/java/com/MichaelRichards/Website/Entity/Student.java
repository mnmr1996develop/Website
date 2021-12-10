package com.MichaelRichards.Website.Entity;

import com.MichaelRichards.Website.Model.Review;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
                targetEntity = Tutor.class)
    @JoinTable(name = "tutors",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "tutor_id"))
    private List<Tutor> tutors;


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

    public void addTutor(Tutor tutor){
        if(tutors == null){
            tutors = new ArrayList<>();
        }
        tutors.add(tutor);
    }

    public List<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
    }
}
