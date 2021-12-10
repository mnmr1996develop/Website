package com.MichaelRichards.Website.Entity;


import com.MichaelRichards.Website.Model.TutorDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tutor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tutor extends User {

    @NotNull
    @Column(name = "locked")
    private boolean locked;

    @NotNull
    @Column(name = "enabled")
    private boolean enabled;

    @Transient
    private UserRoles userRoles;

    @ManyToMany(mappedBy = "tutors")
    private List<Student> students;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_details_id")
    private TutorDetails tutorDetails;


    public Tutor() {
        super();
        this.locked = false;
        this.enabled = true;
        this.userRoles = UserRoles.Tutor;
    }

    public Tutor(String firstName, String lastName, String username, String password, String email, LocalDate birthday) {
        super(firstName, lastName, username, password, email, birthday);
        this.locked = false;
        this.enabled = true;
        this.userRoles = UserRoles.Tutor;
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

    public void addStudent(Student student){
        if(students == null){
            students = new ArrayList<>();

        }
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public TutorDetails getTutorDetails() {
        return tutorDetails;
    }

    public void setTutorDetails(TutorDetails tutorDetails) {
        this.tutorDetails = tutorDetails;
    }
}
