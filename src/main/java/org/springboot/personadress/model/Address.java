package org.springboot.personadress.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", length = 70, nullable = false)
    @NotBlank(message = "Country is required")
    @Size(min = 2, max = 50, message = "Country must be between 2 and 70 characters")
    private String country;

    @Column(name = "city", length = 70, nullable = false)
    @NotBlank(message = "City is required")
    @Size(min = 2, max = 70, message = "City must be between 2 and 70 characters")
    private String city;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
