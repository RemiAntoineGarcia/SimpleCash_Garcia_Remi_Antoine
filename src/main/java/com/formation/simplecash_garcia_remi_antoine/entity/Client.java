package com.formation.simplecash_garcia_remi_antoine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message ="FirstName cannot be empty")
    private String firstName;
    @NotBlank(message ="LastName cannot be empty")
    private String LastName;
    private String Adresse;
    private String PostalCode;
    private String City;
    private String Telephone;
    @Setter
    @Getter
    private long CourantCompte=-1;
    @Setter
    @Getter
    private long EpargneCompte=-1;

}
