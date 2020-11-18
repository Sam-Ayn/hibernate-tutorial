package ru.springcourse.lessons;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.entities.Student;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student1 = new Student("Peter", "Jackson","jackson@gmail.com");
            Student student2 = new Student("Jacob", "Hertings","hertings@gmail.com");
            Student student3 = new Student("Maria", "Espinoza","espinoza@gmail.com");
            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
