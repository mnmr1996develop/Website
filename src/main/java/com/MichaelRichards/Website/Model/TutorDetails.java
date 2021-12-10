package com.MichaelRichards.Website.Model;

import com.MichaelRichards.Website.Entity.Tutor;

import javax.persistence.*;

@Entity
public class TutorDetails {

    public TutorDetails() {
    }

    public TutorDetails(String courseDetails) {
        this.courseDetails = courseDetails;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="course_details")
    private String courseDetails;


    @OneToOne(mappedBy = "tutorDetails", cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Tutor tutor;


    public String getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(String courseDetails) {
        this.courseDetails = courseDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
