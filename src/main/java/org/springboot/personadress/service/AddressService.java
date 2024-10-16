package org.springboot.personadress.service;

import org.springboot.personadress.dto.request.AddressRequestDto;
import org.springboot.personadress.dto.request.PersonRequestDto;
import org.springboot.personadress.dto.response.AddressResponseDto;
import org.springboot.personadress.dto.response.PersonResponseDto;
import org.springboot.personadress.dto.update.AddressUpdateDto;

public interface AddressService {
    AddressResponseDto createAddress(AddressRequestDto addressRequestDto);

    AddressResponseDto updateAddress(AddressUpdateDto addressUpdateDto);

    void deleteAddress(Long id);
}
