package org.springboot.personadress.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springboot.personadress.dto.request.AddressRequestDto;
import org.springboot.personadress.dto.request.PersonRequestDto;
import org.springboot.personadress.dto.response.AddressResponseDto;
import org.springboot.personadress.dto.response.PersonResponseDto;
import org.springboot.personadress.dto.update.AddressUpdateDto;
import org.springboot.personadress.dto.update.PersonUpdateDto;
import org.springboot.personadress.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponseDto> createPerson(@Valid @RequestBody AddressRequestDto addressRequestDto){
        AddressResponseDto addressResponseDto=addressService.createAddress(addressRequestDto);
        return new ResponseEntity<>(addressResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<AddressResponseDto> updateAddress(@PathVariable Long id,@Valid @RequestBody AddressUpdateDto addressUpdateDto){
        addressUpdateDto.setId(id);
        AddressResponseDto addressResponseDto= addressService.updateAddress(addressUpdateDto);
        return new ResponseEntity<>(addressResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Address is deleted", HttpStatus.OK);
    }
}
