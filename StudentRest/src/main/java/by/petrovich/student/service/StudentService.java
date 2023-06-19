package by.petrovich.student.service;

import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> readAll();

    Student create(StudentDto studentDto);

    Optional<Student> read(Long id);

    Student update(StudentDto studentDto);

    void delete(Long id);

}
