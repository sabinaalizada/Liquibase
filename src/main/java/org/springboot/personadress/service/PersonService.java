package org.springboot.personadress.service;

import org.springboot.personadress.dto.request.PersonRequestDto;
import org.springboot.personadress.dto.response.PersonResponseDto;
import org.springboot.personadress.dto.update.PersonUpdateDto;
import org.springboot.personadress.model.Person;

public interface PersonService {
    PersonResponseDto createPerson(PersonRequestDto personRequestDto);

    PersonResponseDto getPersonById(Long id);

    PersonResponseDto updatePerson(PersonUpdateDto personUpdateDto);

    void deletePerson(Long id);
    Person getRealPersonById(Long id);

}
