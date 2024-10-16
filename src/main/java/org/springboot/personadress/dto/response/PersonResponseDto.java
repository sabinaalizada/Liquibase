package org.springboot.personadress.dto.response;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PersonResponseDto {
    private Long id;
    private String name;
    private int age;
    private LocalDate dateOfBirth;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
