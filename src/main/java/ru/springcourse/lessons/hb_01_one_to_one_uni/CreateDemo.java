package ru.springcourse.lessons.hb_01_one_to_one_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_01_one_to_one_uni.entities.Instructor;
import ru.springcourse.lessons.hb_01_one_to_one_uni.entities.InstructorDetail;
import ru.springcourse.lessons.hb_student_tracker.entities.Student;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Chad", "Darby","darby@gmail.com");
            InstructorDetail detail = new InstructorDetail("http://www.l2c.com/youtube","Love 2 code");
            instructor.setInstructorDetail(detail);
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
