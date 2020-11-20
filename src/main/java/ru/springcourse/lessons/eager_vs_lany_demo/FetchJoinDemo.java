package ru.springcourse.lessons.eager_vs_lany_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.springcourse.lessons.eager_vs_lany_demo.entities.Course;
import ru.springcourse.lessons.eager_vs_lany_demo.entities.Instructor;
import ru.springcourse.lessons.eager_vs_lany_demo.entities.InstructorDetail;



public class FetchJoinDemo {
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
            Query<Instructor> query = session.createQuery(
                    "select i from Instructor i " +
                            "join fetch i.courses where i.id=:id",
                    Instructor.class);
            query.setParameter("id", id);
            Instructor instructor = query.getSingleResult();
            session.getTransaction().commit();
            session.close();
            System.out.println("Courses: " + instructor.getCourses());

        } finally {
//            session.close();
            factory.close();
        }
    }
}
