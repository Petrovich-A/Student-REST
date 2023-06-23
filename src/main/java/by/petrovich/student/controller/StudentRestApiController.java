package by.petrovich.student.controller;

import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.entity.Student;
import by.petrovich.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
@Tag(name = "Student", description = "The Student API")
@RequestMapping("/api/v1/students")
public class StudentRestApiController {
    private final StudentService studentService;

    @Operation(summary = "Create student", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Create new student",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    })
    })
    @PostMapping
    public ResponseEntity create(@RequestBody @Valid StudentDto studentDto) {
        return ResponseEntity.ok(studentService.create(studentDto));
    }

    @Operation(summary = "Get all students", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the students",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    })
    })
    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @Operation(summary = "Get student by id", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Find student by id",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }),
            @ApiResponse(responseCode = "404", description = "Student doesn't exist with id:", content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.find(id));
    }

    @Operation(summary = "Delete student by id", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Delete student by id",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    })
    })
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            studentService.delete(id);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update student by id", tags = "student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Update student by id if exist. Otherwise create new student",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }),
            @ApiResponse(responseCode = "404", description = "Student doesn't exist with id: ", content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity<Student> update(@PathVariable long id,
                                          @RequestBody @Valid StudentDto studentDto) {
        return ResponseEntity.ok(studentService.update(id, studentDto));
    }

}
