package ru.springcourse.lessons.hb_04_one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_04_one_to_many_uni.entities.Course;
import ru.springcourse.lessons.hb_04_one_to_many_uni.entities.Instructor;
import ru.springcourse.lessons.hb_04_one_to_many_uni.entities.InstructorDetail;
import ru.springcourse.lessons.hb_04_one_to_many_uni.entities.Review;

public class DeleteCoursesAndRewiewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
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
