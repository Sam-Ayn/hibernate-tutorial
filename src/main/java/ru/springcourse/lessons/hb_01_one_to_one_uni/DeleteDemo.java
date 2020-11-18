package ru.springcourse.lessons.hb_01_one_to_one_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_01_one_to_one_uni.entities.Instructor;
import ru.springcourse.lessons.hb_01_one_to_one_uni.entities.InstructorDetail;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Found instructor" + instructor);
            if (instructor != null ) session.delete(instructor);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
