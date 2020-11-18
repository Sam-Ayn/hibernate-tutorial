package ru.springcourse.lessons;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.entities.Student;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 2;
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            System.out.println("Getting complete: " + student);

            student.setFirstName("Stanley");
            session.getTransaction().commit();

            session= factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='parable@mail.ru' where firstName='Stanley'").executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
