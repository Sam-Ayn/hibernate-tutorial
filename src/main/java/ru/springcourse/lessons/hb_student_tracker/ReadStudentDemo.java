package ru.springcourse.lessons.hb_student_tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_student_tracker.entities.Student;

public class ReadStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Buffy", "Winterbringer","buffy@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student newStudent = session.get(Student.class, student.getId());
            System.out.println("Getting complete: " + newStudent);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
