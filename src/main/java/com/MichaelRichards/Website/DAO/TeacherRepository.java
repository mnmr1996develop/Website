package com.MichaelRichards.Website.DAO;

import com.MichaelRichards.Website.Entity.Student;
import com.MichaelRichards.Website.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Student> findByUsername(String username);

    Optional<Student> findByEmail(String email);


}
