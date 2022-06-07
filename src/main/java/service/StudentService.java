package service;

import dao.StudentDao;
import entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentDao studentDao;

    public void createRandomStudents() {
        studentDao.createRandomStudents();
    }

    public void add(Student student) {
        studentDao.add(student);
    }

    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    public void delete(Student student) {
        studentDao.delete(student);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findById(Long id) {
        return studentDao.findById(id);
    }

    public Student findByName(String name) {
        return studentDao.findByName(name);
    }
}