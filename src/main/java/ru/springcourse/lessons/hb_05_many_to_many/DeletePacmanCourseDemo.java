package ru.springcourse.lessons.hb_05_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_05_many_to_many.entities.*;

public class DeletePacmanCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int courseId = 10;
            Course course = session.get(Course.class, courseId);
            session.delete(course);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
