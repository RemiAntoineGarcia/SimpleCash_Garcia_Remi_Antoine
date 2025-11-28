package com.formation.simplecash_garcia_remi_antoine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message ="FirstName cannot be empty")
    private String FirstName;
    @NotBlank(message ="LastName cannot be empty")
    private String LastName;
    private String Adresse;
    private String PostalCode;
    private String City;
    private String Telephone;

    private long CourantCompte;
    private long EpargneCompte;

}
