package ru.springcourse.lessons.hb_05_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springcourse.lessons.hb_05_many_to_many.entities.Course;
import ru.springcourse.lessons.hb_05_many_to_many.entities.Instructor;
import ru.springcourse.lessons.hb_05_many_to_many.entities.InstructorDetail;
import ru.springcourse.lessons.hb_05_many_to_many.entities.Review;
import ru.springcourse.lessons.hb_05_many_to_many.entities.Student;

public class CreateCoursesAndStudentsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Course course = new Course("Pacman - How to score one million points");
            session.save(course);
            Student firstStudent = new Student("John", "Doe", "doe@gmail.com");
            Student secondStudent = new Student("Mary", "Daa", "daa@gmail.com");

            course.addStudent(firstStudent);
            course.addStudent(secondStudent);

            session.save(firstStudent);
            session.save(secondStudent);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
