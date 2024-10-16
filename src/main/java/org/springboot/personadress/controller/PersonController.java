package org.springboot.personadress.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springboot.personadress.dto.request.PersonRequestDto;
import org.springboot.personadress.dto.response.PersonResponseDto;
import org.springboot.personadress.dto.update.PersonUpdateDto;
import org.springboot.personadress.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonResponseDto> createPerson(@Valid @RequestBody PersonRequestDto personRequestDto){
        PersonResponseDto personResponseDto=personService.createPerson(personRequestDto);
        return new ResponseEntity<>(personResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonResponseDto> getPersonById(@PathVariable Long id){
        PersonResponseDto personResponseDto= personService.getPersonById(id);
        return new ResponseEntity<>(personResponseDto, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<PersonResponseDto> updatePerson(@PathVariable Long id,@Valid @RequestBody PersonUpdateDto personUpdateDto){
        personUpdateDto.setId(id);
        PersonResponseDto personResponseDto= personService.updatePerson(personUpdateDto);
        return new ResponseEntity<>(personResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return new ResponseEntity<>("Person deleted", HttpStatus.OK);
    }

}
