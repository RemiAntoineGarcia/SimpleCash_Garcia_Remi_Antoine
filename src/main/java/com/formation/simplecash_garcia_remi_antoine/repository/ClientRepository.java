package com.formation.simplecash_garcia_remi_antoine.repository;

import com.formation.simplecash_garcia_remi_antoine.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByFirstName(String firstName);
}
