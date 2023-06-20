package by.petrovich.student.service.impl;

import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.entity.Student;
import by.petrovich.student.repository.StudentRepository;
import by.petrovich.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> readAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student create(StudentDto studentDto) {
        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .build();
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> read(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student update(StudentDto studentDto) {
        Student student = Student.builder()
                .id(11)
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .build();
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

}
