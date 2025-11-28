package com.formation.simplecash_garcia_remi_antoine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteCourantEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Setter
    @Getter
    private double solde;
    private String CreatedDate;
    @Getter
    @Max(0)
    private double decouverMax = -1000;

}
