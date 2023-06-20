package by.petrovich.student.controller;

import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.entity.Student;
import by.petrovich.student.service.StudentService;
import jakarta.validation.Valid;
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
@RequestMapping("/api/v1/students")
public class StudentRestApiController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid StudentDto studentDto) {
        Student student = studentService.create(studentDto);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.readAll();
    }

    @GetMapping("{id}")
    public ResponseEntity findStudent(@PathVariable long id) {
        return ResponseEntity.ok(studentService.read(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        studentService.delete(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> update(@PathVariable long id,
                                          @RequestBody @Valid StudentDto studentDto) {
        return ResponseEntity.ok(studentService.update(id, studentDto));
    }

}
