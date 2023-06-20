package by.petrovich.student.controller;

import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.entity.Student;
import by.petrovich.student.exception.ResourceNotFoundException;
import by.petrovich.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentRestApiController {
    private final StudentService studentService;

//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody StudentDto studentDto) {
        Student student = studentService.create(studentDto);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findStudent(@PathVariable long id) {
        Student student = studentService.read(id).orElseThrow(() -> new ResourceNotFoundException("Student doesn't exist with id: " + id));
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable long id,
                                          @RequestBody StudentDto studentDto) {
        Student student = studentService.read(id).
                orElseThrow(() -> new ResourceNotFoundException("Student doesn't exist with id: " + id));
        Student studentUpdated = new Student();
        if (student != null) {
            studentUpdated = studentService.update(studentDto);
        }
        return ResponseEntity.ok(studentUpdated);
    }

}
