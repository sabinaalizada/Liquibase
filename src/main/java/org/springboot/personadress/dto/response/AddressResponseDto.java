package org.springboot.personadress.dto.response;

import lombok.Data;

@Data
public class AddressResponseDto {

    private Long id;
    private String country;
    private String city;

    private PersonResponseDto personResponseDto;

}
