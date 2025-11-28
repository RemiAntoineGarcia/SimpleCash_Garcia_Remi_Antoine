package com.formation.simplecash_garcia_remi_antoine.repository;

import com.formation.simplecash_garcia_remi_antoine.dto.ClientUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.entity.Client;
import com.formation.simplecash_garcia_remi_antoine.entity.CompteCourantEntity;
import com.formation.simplecash_garcia_remi_antoine.entity.CompteEpargneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteEpargneRepository extends JpaRepository<CompteEpargneEntity, Long> {

}
