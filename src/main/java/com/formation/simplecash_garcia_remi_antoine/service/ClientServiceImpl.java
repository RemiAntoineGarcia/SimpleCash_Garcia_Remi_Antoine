package com.formation.simplecash_garcia_remi_antoine.service;

import com.formation.simplecash_garcia_remi_antoine.dto.ClientDataDto;
import com.formation.simplecash_garcia_remi_antoine.mapper.ClientMapper;
import com.formation.simplecash_garcia_remi_antoine.repository.ClientRepository;
import com.formation.simplecash_garcia_remi_antoine.entity.Client;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;

/*
    @PostConstruct
    private void initDb() {

        repository.saveAll(List.of(
                new Client(null,"Parde", "Fault", "123 Rue Principale", "75001", "Paris", "0123456789", 1000L, 5000L),
                new Client(null,"Jane", "Smith", "456 Avenue du Parc", "69001", "Lyon", "0987654321", 2000L, 3000L),
                new Client(null,"Alice", "Martin", "789 Boulevard Sud", "13001", "Marseille", "0147258369", 1500L, 2500L)
        ));
    }*/
    @Override
    public List<ClientDataDto> findAll()
    {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }


}
