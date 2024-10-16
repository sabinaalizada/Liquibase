package org.springboot.personadress.service.impl;

import lombok.AllArgsConstructor;
import org.springboot.personadress.dto.request.PersonRequestDto;
import org.springboot.personadress.dto.response.PersonResponseDto;
import org.springboot.personadress.dto.update.PersonUpdateDto;
import org.springboot.personadress.mapper.PersonMapper;
import org.springboot.personadress.model.Person;
import org.springboot.personadress.repository.PersonRepository;
import org.springboot.personadress.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public PersonResponseDto createPerson(PersonRequestDto personRequestDto) {
        Person person = PersonMapper.MAPPER.mapToPerson(personRequestDto);
        Person savedPerson = personRepository.save(person);
        return PersonMapper.MAPPER.mapToPersonResponseDto(savedPerson);
    }

    @Override
    public PersonResponseDto getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Person with ID " + id + " not found")
        );
        return PersonMapper.MAPPER.mapToPersonResponseDto(person);
    }

    @Override
    public PersonResponseDto updatePerson(PersonUpdateDto personUpdateDto) {
        Person existingPerson = personRepository.findById(personUpdateDto.getId()).orElseThrow(
                () -> new NoSuchElementException("Person with ID " + personUpdateDto.getId() + " not found"));
        existingPerson.setName(personUpdateDto.getName());
        existingPerson.setAge(personUpdateDto.getAge());
        existingPerson.setDateOfBirth(personUpdateDto.getDateOfBirth());

        Person savedPerson = personRepository.save(existingPerson);

        return PersonMapper.MAPPER.mapToPersonResponseDto(savedPerson);
    }

    @Override
    public void deletePerson(Long id) {
        Person existingPerson = personRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Person with ID " + id + " not found"));
        personRepository.deleteById(existingPerson.getId());
    }

    @Override
    public Person getRealPersonById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }
}
