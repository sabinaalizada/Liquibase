package org.springboot.personadress.service.impl;

import lombok.AllArgsConstructor;
import org.springboot.personadress.dto.request.AddressRequestDto;
import org.springboot.personadress.dto.response.AddressResponseDto;
import org.springboot.personadress.dto.response.PersonResponseDto;
import org.springboot.personadress.dto.update.AddressUpdateDto;
import org.springboot.personadress.mapper.AddressMapper;
import org.springboot.personadress.mapper.PersonMapper;
import org.springboot.personadress.model.Address;
import org.springboot.personadress.model.Person;
import org.springboot.personadress.repository.AddressRepository;
import org.springboot.personadress.service.AddressService;
import org.springboot.personadress.service.PersonService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    AddressRepository addressRepository;

    PersonService personService;
    @Override
    public AddressResponseDto createAddress(AddressRequestDto addressRequestDto) {
        Address address=new Address();

        address.setCity(addressRequestDto.getCity());
        address.setCountry(addressRequestDto.getCountry());
        Person person=personService.getRealPersonById(addressRequestDto.getPersonId());
        address.setPerson(person);
        Address savedAddress= addressRepository.save(address);

        AddressResponseDto addressResponseDto=AddressMapper.MAPPER.mapToAddressResponseDto(savedAddress);

        PersonResponseDto personResponseDto= PersonMapper.MAPPER.mapToPersonResponseDto(savedAddress.getPerson());

        addressResponseDto.setPersonResponseDto(personResponseDto);

        return addressResponseDto;
    }

    @Override
    public AddressResponseDto updateAddress(AddressUpdateDto addressUpdateDto) {

        Address existingAddress=addressRepository.findById(addressUpdateDto.getId()).orElseThrow();
        existingAddress.setCity(addressUpdateDto.getCity());
        existingAddress.setCountry(addressUpdateDto.getCountry());
        Person person=personService.getRealPersonById(addressUpdateDto.getPersonId());
        existingAddress.setPerson(person);
        Address address=addressRepository.save(existingAddress);

        AddressResponseDto addressResponseDto=AddressMapper.MAPPER.mapToAddressResponseDto(address);

        PersonResponseDto personResponseDto=PersonMapper.MAPPER.mapToPersonResponseDto(address.getPerson());

        addressResponseDto.setPersonResponseDto(personResponseDto);

        return addressResponseDto;
    }

    @Override
    public void deleteAddress(Long id) {
        Address address=addressRepository.findById(id).orElseThrow();
        addressRepository.deleteById(address.getId());
    }
}
