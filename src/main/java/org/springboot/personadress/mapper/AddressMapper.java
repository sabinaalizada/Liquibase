package org.springboot.personadress.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springboot.personadress.dto.request.AddressRequestDto;
import org.springboot.personadress.dto.request.PersonRequestDto;
import org.springboot.personadress.dto.response.AddressResponseDto;
import org.springboot.personadress.dto.response.PersonResponseDto;
import org.springboot.personadress.model.Address;
import org.springboot.personadress.model.Person;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);

    Address mapToAddress(AddressRequestDto addressRequestDto);

    AddressResponseDto mapToAddressResponseDto(Address address);

}
