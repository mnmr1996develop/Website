package com.MichaelRichards.Website;

import com.MichaelRichards.Website.Entity.Student;;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Student student = new Student("mike", "RIchard",   "username", "password",  "email", LocalDate.of(1996,11,15));
        System.out.println(student.getAge());
    }
}
