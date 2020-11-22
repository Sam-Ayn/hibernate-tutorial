package ru.springcourse.lessons.hb_05_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_05_many_to_many.entities.*;

public class AddCoursesForMary {
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
            int id = 2;
            Student student = session.get(Student.class, 2);

            Course newCourse1 = new Course("Rubik's Cube - How to speed cube");
            Course newCourse2 = new Course("Atari 2600 - Game development");

            student.addCourse(newCourse1);
            student.addCourse(newCourse2);

            session.save(newCourse1);
            session.save(newCourse2);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
