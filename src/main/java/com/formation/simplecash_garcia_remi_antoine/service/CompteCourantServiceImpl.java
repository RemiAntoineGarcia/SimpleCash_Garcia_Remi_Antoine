package com.formation.simplecash_garcia_remi_antoine.service;

import com.formation.simplecash_garcia_remi_antoine.dto.CompteCourantCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteCourantDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteCourantUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.entity.Client;
import com.formation.simplecash_garcia_remi_antoine.entity.CompteCourantEntity;
import com.formation.simplecash_garcia_remi_antoine.mapper.CompteCourantMapper;
import com.formation.simplecash_garcia_remi_antoine.repository.ClientRepository;
import com.formation.simplecash_garcia_remi_antoine.repository.CompteCourantRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompteCourantServiceImpl implements CompteCourantService {
    private final CompteCourantRepository repository;
    private final CompteCourantMapper mapper;
    private final ClientRepository clientRepository;

    @PostConstruct
    private void initDb() {

        repository.saveAll(List.of(
        ));
    }
    @Override
    public List<CompteCourantDto> findAll()
    {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<CompteCourantDto> getCompteById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public CompteCourantDto save(long ownerId, CompteCourantCreateDto dto) {
        Optional<Client> client = clientRepository.findById(ownerId);
        if ((client.isEmpty()) || (client.get().getCourantCompte() == -1))
        {return null;}

        CompteCourantEntity entity = mapper.ToEntity(dto);
        entity = repository.save(entity);
        client.get().setCourantCompte(entity.getId());
        return mapper.toDto(entity);
    }

    @Override
    public Optional<CompteCourantDto> update(Long id, CompteCourantUpdateDto dto) {
        return repository.findById(id).map(
                existingCompteCourant ->{ mapper.updateEntity(existingCompteCourant, dto);
                return mapper.toDto(repository.save(existingCompteCourant));}
        );
    }

    @Override
    public Optional<CompteCourantDto> updateMoney(Long id, double money) {
        return repository.findById(id).map(
                existingCompteCourant ->
                {
                    if(existingCompteCourant.getSolde() + money >= existingCompteCourant.getDecouverMax())
                    {
                        existingCompteCourant.setSolde(existingCompteCourant.getSolde() + money);
                        //mapper.updateEntity(existingCompteCourant, existingCompteCourant);
                        return mapper.toDto(repository.save(existingCompteCourant));
                    }
                    else
                    {return null;}
                }

        );
    }

    @Override
    public Boolean delete(Long id) {
        return repository.findById(id).map(existingCompteCourant -> {repository.delete(existingCompteCourant);
            return true;
        }).orElse(false);

    }

}
