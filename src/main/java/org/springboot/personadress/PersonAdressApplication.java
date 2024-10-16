package org.springboot.personadress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonAdressApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonAdressApplication.class, args);
	}

}

//person cotrollerdə(
//		create
//				getpersonbyid
//deleteperson
//				updateperson endpointlərinin yazılması)
//
//addresscotrollerdə(
//		createaddress persona görə-personid ilə birlikdə
//		getaddress by id-delete  address
//		address update-address address id-ə görə update)
//
//NOT:səliqəli yazılmalı,comment olmamalı
//NOT:toollar
//             1)database-postgres
//             2)dto dao
//             3)table lequabase
//             4)mapstruct