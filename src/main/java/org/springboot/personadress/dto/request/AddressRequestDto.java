package org.springboot.personadress.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressRequestDto {
    @NotBlank(message = "Country is required")
    @Size(min = 2, max = 50, message = "Country must be between 2 and 70 characters")
    private String country;

    @NotBlank(message = "City is required")
    @Size(min = 2, max = 70, message = "City must be between 2 and 70 characters")
    private String city;

    private Long personId;
}
