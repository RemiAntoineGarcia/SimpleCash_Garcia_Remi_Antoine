package com.formation.simplecash_garcia_remi_antoine.service;

import com.formation.simplecash_garcia_remi_antoine.dto.ClientCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.ClientDataDto;
import com.formation.simplecash_garcia_remi_antoine.dto.ClientUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientDataDto> findAll();

    Optional<ClientDataDto> getClientById(Long id);
    Optional<ClientDataDto> getClientByFirstName(String name);
    ClientDataDto save(ClientCreateDto dto);
    Optional<ClientDataDto> update(Long id, ClientUpdateDto dto);
}
