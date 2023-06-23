package by.petrovich.student.service;

import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student create(StudentDto studentDto);

    Student find(Long id);

    Student update(Long id, StudentDto studentDto);

    void delete(Long id);

}
