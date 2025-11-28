package com.formation.simplecash_garcia_remi_antoine.controller;

import com.formation.simplecash_garcia_remi_antoine.dto.ClientDataDto;
import com.formation.simplecash_garcia_remi_antoine.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @GetMapping
    public List<ClientDataDto> getAllClientData()
    {
        return clientService.findAll();
    }

}
