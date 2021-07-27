package de.neuefische.rem21_3.spring.controller;

import de.neuefische.rem21_3.spring.model.Student;
import de.neuefische.rem21_3.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {

    //@Resource(name = "default")
    private final StudentService studentService;

    @Autowired
    public StudentController(@Qualifier("other") StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student")
    public Student getStudentByPath(@RequestParam(name = "matNumber") String matNumber) {
        return studentService.getStudent(matNumber);
    }

    @GetMapping("/student/{matNumber}")
    public Student getStudentByRequestParam(@PathVariable String matNumber) {
        return studentService.getStudent(matNumber);
    }

    @PutMapping("/student/{matNumber}")
    public Student getStudentByRequestParam(@PathVariable String matNumber, @RequestBody Student student) {
        return studentService.updateStudent(matNumber, student);
    }
}
