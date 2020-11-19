package ru.springcourse.lessons.hb_03_one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_03_one_to_many.entities.Course;
import ru.springcourse.lessons.hb_03_one_to_many.entities.Instructor;
import ru.springcourse.lessons.hb_03_one_to_many.entities.InstructorDetail;

public class DeleteCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int courseId = 10;
            Course course = session.get(Course.class, courseId);

            System.out.println("Deleting course" + course);
            session.delete(course);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
