package by.petrovich.student.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class StudentDto {
    @NotNull
    private long id;
    @Length(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    private String firstName;
    @Length(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    private String lastName;
}
