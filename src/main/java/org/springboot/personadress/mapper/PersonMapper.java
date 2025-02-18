package org.springboot.personadress.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springboot.personadress.dto.request.PersonRequestDto;
import org.springboot.personadress.dto.response.PersonResponseDto;
import org.springboot.personadress.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper MAPPER= Mappers.getMapper(PersonMapper.class);
    Person mapToPerson(PersonRequestDto personRequestDto);
    PersonResponseDto mapToPersonResponseDto(Person person);
}
