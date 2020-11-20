package ru.springcourse.lessons.eager_vs_lany_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.eager_vs_lany_demo.entities.Course;
import ru.springcourse.lessons.eager_vs_lany_demo.entities.Instructor;
import ru.springcourse.lessons.eager_vs_lany_demo.entities.InstructorDetail;

public class EagerLazyDemo {
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
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Courses: " + instructor.getCourses());

            session.getTransaction().commit();
            session.close();
            System.out.println("Courses: " + instructor.getCourses());
        } finally {
//            session.close();
            factory.close();
        }
    }
}
