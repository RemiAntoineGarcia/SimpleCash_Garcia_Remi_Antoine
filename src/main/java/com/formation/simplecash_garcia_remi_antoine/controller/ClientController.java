package com.formation.simplecash_garcia_remi_antoine.controller;

import com.formation.simplecash_garcia_remi_antoine.dto.ClientCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.ClientDataDto;
import com.formation.simplecash_garcia_remi_antoine.dto.ClientUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @GetMapping
    public List<ClientDataDto> getAllClientData()
    {
        return clientService.findAll();
    }
    @GetMapping("{id}")
    public ClientDataDto getAllClientDataById(@PathVariable @Valid Long id)
    {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()).getBody();
    }
    @GetMapping("name/{firstName}")
    public ClientDataDto getClientDataByFirstName(@PathVariable @Valid String firstName)
    {

        return clientService.getClientByFirstName(firstName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()).getBody();
    }
    @PostMapping
    public ClientDataDto save(@Valid ClientCreateDto dto)
    {return clientService.save(dto);}

    @PatchMapping("{id}")
    public ResponseEntity<ClientDataDto> updateClient(@PathVariable @Valid Long id,@RequestBody @Valid ClientUpdateDto dto)
    {
        return clientService.update(id,dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
