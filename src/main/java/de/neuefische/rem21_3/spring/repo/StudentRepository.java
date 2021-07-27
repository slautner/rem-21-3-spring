package de.neuefische.rem21_3.spring.repo;

import de.neuefische.rem21_3.spring.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList();

    public StudentRepository() {
        students.addAll(
                List.of(
                        new Student("Martin", "5"),
                        new Student("Florian", "10")
                )
        );
    }

    public List<Student> findAll() {
        return students;
    }
}
