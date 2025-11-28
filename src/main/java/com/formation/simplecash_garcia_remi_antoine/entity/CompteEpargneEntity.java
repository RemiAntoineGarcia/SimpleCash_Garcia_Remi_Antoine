package com.formation.simplecash_garcia_remi_antoine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteEpargneEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Getter
    private double solde =0;
    private String createdDate;
    @Getter
    private double interest = 0.03;

}
