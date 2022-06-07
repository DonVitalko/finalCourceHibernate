package utils;

import entity.Student;

import java.util.List;
import java.util.Random;

public class StudentUtils {
    private static final List<String> names;

    static {
        names = List.of("Harry", "Oliver", "Jack", "Charlie", "Thomas", "Jacob",
                "Alfie", "Riley", "William", "James", "Amelia", "Olivia", "Jessica", "Emily",
                "Lily", "Ava", "Heather", "Sophie", "Mia", "Isabella");
    }

    private StudentUtils() {
    }

    public static Student getNewStudent() {
        Random random = new Random();
        return new Student(names.get(random.nextInt(names.size())), 1 + random.nextInt(5));
    }
}