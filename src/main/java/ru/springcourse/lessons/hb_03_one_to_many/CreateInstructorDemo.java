package ru.springcourse.lessons.hb_03_one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_03_one_to_many.entities.Instructor;
import ru.springcourse.lessons.hb_03_one_to_many.entities.InstructorDetail;
import ru.springcourse.lessons.hb_03_one_to_many.entities.Course;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Susan", "Bloom","bloom@gmail.com");
            InstructorDetail detail = new InstructorDetail("http://www.youtube.com","Dancing");
            instructor.setInstructorDetail(detail);
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
