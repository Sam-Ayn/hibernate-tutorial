package ru.springcourse.lessons.hb_student_tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_student_tracker.entities.Student;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> list = session.createQuery("from Student s order by s.lastName").getResultList();
            printStudentList(list);
            list = session.createQuery("from Student s where s.lastName='Hoff'").getResultList();
            printStudentList(list);
            list = session.createQuery("from Student s where s.lastName='Hoff' or s.firstName='Max'").getResultList();
            printStudentList(list);
            list = session.createQuery("from Student s where s.email like '%@gmail.com'").getResultList();
            printStudentList(list);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    private static void printStudentList(List<Student> list) {
        for (Student student: list) {
            System.out.println(student);
        }
    }
}
