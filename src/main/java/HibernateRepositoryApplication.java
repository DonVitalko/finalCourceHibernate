import configuration.HibernateConfiguration;
import entity.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.StudentService;

@SpringBootApplication
public class HibernateRepositoryApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
        StudentService studentService = context.getBean(StudentService.class);

        studentService.createRandomStudents();
        System.out.println("Number of students: " + studentService.findAll().size());

        Student newStudent = new Student("Newbie", 5);
        studentService.add(newStudent);
        System.out.println("Add new student");
        System.out.println("Number of students: " + studentService.findAll().size());
        System.out.println("New student: " + studentService.findByName(newStudent.getName()));

        System.out.println("Exclude new student");
        newStudent = studentService.findByName(newStudent.getName());
        studentService.delete(newStudent);
        System.out.println("Number of students: " + studentService.findAll().size());

        Student student = studentService.findById(1L);
        System.out.println("Student number 1: " + student);

        System.out.println("Update student number 1");
        student.setName("Peter");
        student.setMark(5);
        studentService.update(student);
        System.out.println("Updated student number 1: " + studentService.findById(1L));

        System.out.println("Exclude student number 1");
        studentService.delete(student);
        System.out.println("Number of students: " + studentService.findAll().size());
        System.out.println(studentService.findById(1L));
    }
}