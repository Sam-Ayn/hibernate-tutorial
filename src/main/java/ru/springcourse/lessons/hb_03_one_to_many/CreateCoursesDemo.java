package ru.springcourse.lessons.hb_03_one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_03_one_to_many.entities.Course;
import ru.springcourse.lessons.hb_03_one_to_many.entities.Instructor;
import ru.springcourse.lessons.hb_03_one_to_many.entities.InstructorDetail;

public class CreateCoursesDemo {
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
            Course course1 = new Course("Lindy Hop Course");
            Course course2 = new Course("Bachata Course");
            instructor.add(course1);
            instructor.add(course2);
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
