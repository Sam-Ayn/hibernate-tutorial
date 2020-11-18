package ru.springcourse.lessons.hb_01_one_to_one_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_01_one_to_one_bi.entities.Instructor;
import ru.springcourse.lessons.hb_01_one_to_one_bi.entities.InstructorDetail;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int id = 3;
            InstructorDetail detail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor detail: " + detail);
            System.out.println("Associated instructor: " + detail.getInstructor());
            detail.getInstructor().setInstructorDetail(null);
            session.delete(detail);
            session.getTransaction().commit();
        } catch (Exception  e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
