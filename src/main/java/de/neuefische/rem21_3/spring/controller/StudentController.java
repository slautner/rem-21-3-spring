package de.neuefische.rem21_3.spring.controller;

import de.neuefische.rem21_3.spring.model.Student;
import de.neuefische.rem21_3.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;


@RestController
public class StudentController {

    //@Resource(name = "default")
    private final StudentService studentService;

    @Autowired
    public StudentController(@Qualifier("other") StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return ok(studentService.getStudents());
    }

    @GetMapping("/student")
    public ResponseEntity<Student> getStudentByPath(@RequestParam(name = "matNumber") String matNumber) {
        Optional<Student> studentOpt = studentService.getStudent(matNumber);
        return getStudentResponse(studentOpt);
    }

    @GetMapping("/student/{matNumber}")
    public ResponseEntity<Student> getStudentByRequestParam(@PathVariable String matNumber) {
        Optional<Student> studentOpt = studentService.getStudent(matNumber);
        return getStudentResponse(studentOpt);
    }

    @PutMapping("/student/{matNumber}")
    public ResponseEntity<Student> getStudentByRequestParam(@PathVariable String matNumber, @RequestBody Student student) {
        Optional<Student> studentOpt = studentService.updateStudent(matNumber, student);
        return getStudentResponse(studentOpt);
    }

    private ResponseEntity<Student> getStudentResponse(Optional<Student> studentOpt) {
        if (studentOpt.isPresent()) {
            return ok(studentOpt.get());
        }
        return notFound().build();
    }
}
