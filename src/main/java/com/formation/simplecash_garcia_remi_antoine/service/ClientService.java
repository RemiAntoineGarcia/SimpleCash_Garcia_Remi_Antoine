package com.formation.simplecash_garcia_remi_antoine.service;

import com.formation.simplecash_garcia_remi_antoine.dto.ClientDataDto;

import java.util.List;

public interface ClientService {
    List<ClientDataDto> findAll();

}
