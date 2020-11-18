package ru.springcourse.lessons.hb_student_tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_student_tracker.entities.Student;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            System.out.println("Getting complete: " + student);
            //session.delete(student); can't delete null object

            session.createQuery("delete from Student where id = 6").executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
