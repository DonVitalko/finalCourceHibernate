package dao;

import entity.Student;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import utils.StudentUtils;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:application.yml")
public class StudentDao {
    private final SessionFactory sessionFactory;

    @Value("${number-of-students}")
    private static Integer numberOfStudents;

    @Transactional
    public void createRandomStudents() {
        Session session = sessionFactory.getCurrentSession();
        Student student;
        for (int i = 0; i < numberOfStudents; i++) {
            student = StudentUtils.getNewStudent();
            session.save(student);
        }
    }

    @Transactional
    public void add(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Transactional
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        session.remove(student);
    }

    @Transactional
    public void delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student removeStudent = session.get(Student.class, student.getId());
        session.remove(removeStudent);
    }

    @Transactional
    public void update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student updatedStudent = session.get(Student.class, student.getId());
        updatedStudent.setName(student.getName());
        updatedStudent.setMark(student.getMark());
    }

    @Transactional
    public List<Student> findAll() {
        return Collections.unmodifiableList(sessionFactory.getCurrentSession().createQuery("from Student s").list());
    }

    @Transactional
    public Student findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Transactional
    public Student findByName(String studentName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("SELECT s FROM Student s WHERE s.name =:studentName", Student.class);
        query.setParameter("studentName", studentName);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}