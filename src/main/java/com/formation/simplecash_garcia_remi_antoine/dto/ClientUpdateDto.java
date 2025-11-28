package com.formation.simplecash_garcia_remi_antoine.dto;

public record ClientUpdateDto(String firstName, String lastName,
                              String adresse, String postalCode,String city,String telephone,
                              long courantCompte, long epargneCompte) {
}
