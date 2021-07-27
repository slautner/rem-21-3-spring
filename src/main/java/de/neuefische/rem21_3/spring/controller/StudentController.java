package de.neuefische.rem21_3.spring.controller;

import de.neuefische.rem21_3.spring.model.Student;
import de.neuefische.rem21_3.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/student")
public class StudentController {

    //@Resource(name = "default")
    private final StudentService studentService;

    @Autowired
    public StudentController(@Qualifier("readWrite") StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents() {
        return ok(studentService.getStudents());
    }

    @GetMapping()
    public ResponseEntity<Student> getStudentByRequestParam(@RequestParam(name = "matNumber") String matNumber) {
        Optional<Student> studentOpt = studentService.getStudent(matNumber);
        return getStudentResponse(studentOpt);
    }


    @GetMapping("{matNumber}")
    public ResponseEntity<Student> getStudentByPath(@PathVariable String matNumber) {
        Optional<Student> studentOpt = studentService.getStudent(matNumber);
        return getStudentResponse(studentOpt);
    }

    @PutMapping("{matNumber}")
    public ResponseEntity<Student> updateStudent(@PathVariable String matNumber, @RequestBody Student student) {
        Optional<Student> studentOpt = studentService.updateStudent(matNumber, student);
        return getStudentResponse(studentOpt);
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student studentCreated = studentService.createStudent(student);

        URI studentLocation = URI.create("/student/" + studentCreated.getMatNumber());
        return ResponseEntity.created(studentLocation).body(studentCreated);
    }

    @DeleteMapping("{matNumber}")
    public ResponseEntity<Student> deleteStudent(@PathVariable String matNumber) {
        Optional<Student> studentOpt = studentService.deleteStudent(matNumber);
        return getStudentResponse(studentOpt);
    }

    private ResponseEntity<Student> getStudentResponse(Optional<Student> studentOpt) {
        if (studentOpt.isPresent()) {
            return ok(studentOpt.get());
        }
        return notFound().build();
    }
}
