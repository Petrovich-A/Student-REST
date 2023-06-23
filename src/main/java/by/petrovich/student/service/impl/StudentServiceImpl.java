package by.petrovich.student.service.impl;

import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.entity.Student;
import by.petrovich.student.exception.ResourceNotFoundException;
import by.petrovich.student.repository.StudentRepository;
import by.petrovich.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student create(StudentDto studentDto) {
        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .build();
        return studentRepository.save(student);
    }

    @Override
    public Student find(Long id) {
        return studentRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Student doesn't exist with id: " + id));
    }

    @Override
    @Transactional
    public Student update(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id)
                .map(s -> Student.builder()
                        .id(id)
                        .firstName(studentDto.getFirstName())
                        .lastName(studentDto.getLastName())
                        .build())
                .orElseThrow(() -> new ResourceNotFoundException("Student doesn't exist with id: " + id));
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

}
