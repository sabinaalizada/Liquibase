package org.springboot.personadress.repository;

import org.springboot.personadress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
