package com.formation.simplecash_garcia_remi_antoine.service;

import com.formation.simplecash_garcia_remi_antoine.dto.ClientCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.ClientDataDto;
import com.formation.simplecash_garcia_remi_antoine.dto.ClientUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.mapper.ClientMapper;
import com.formation.simplecash_garcia_remi_antoine.repository.ClientRepository;
import com.formation.simplecash_garcia_remi_antoine.entity.Client;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final ClientMapper mapper;


    @PostConstruct
    private void initDb() {

        repository.saveAll(List.of(
                new Client(null,"Parde", "Fault", "123 Rue Principale", "75001", "Paris", "0123456789", 1000L, 5000L),
                new Client(null,"Jane", "Smith", "456 Avenue du Parc", "69001", "Lyon", "0987654321", 2000L, 3000L),
                new Client(null,"Marie", "Gnan", "789 Boulevard Sud", "13001", "Marseille", "0147258369", 1500L, 2500L)
        ));
    }
    @Override
    public List<ClientDataDto> findAll()
    {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<ClientDataDto> getClientById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public Optional<ClientDataDto> getClientByFirstName(String name) {
        return repository.findByFirstName(name).map(mapper::toDto);
    }

    @Override
    public ClientDataDto save(ClientCreateDto dto) {
        Client entity = mapper.ToEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public Optional<ClientDataDto> update(Long id, ClientUpdateDto dto) {
        return repository.findById(id).map(
                existingClient ->{ mapper.updateEntity(existingClient, dto);
                return mapper.toDto(repository.save(existingClient));}
        );
    }

    @Override
    public Boolean delete(Long id) {
        return repository.findById(id).map(existingClient -> {repository.delete(existingClient);
            return true;
        }).orElse(false);

    }

}
