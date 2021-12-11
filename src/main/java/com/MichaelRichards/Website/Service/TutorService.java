package com.MichaelRichards.Website.Service;

import com.MichaelRichards.Website.DAO.TutorRepository;
import com.MichaelRichards.Website.Entity.Tutor;
import org.springframework.stereotype.Service;


@Service
public class TutorService  extends UserService<Tutor, TutorRepository> {
}
