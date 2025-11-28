package com.formation.simplecash_garcia_remi_antoine.service;

import com.formation.simplecash_garcia_remi_antoine.dto.CompteEpargneCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteEpargneDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteEpargneUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.entity.Client;
import com.formation.simplecash_garcia_remi_antoine.entity.CompteEpargneEntity;
import com.formation.simplecash_garcia_remi_antoine.mapper.CompteEpargneMapper;
import com.formation.simplecash_garcia_remi_antoine.repository.ClientRepository;
import com.formation.simplecash_garcia_remi_antoine.repository.CompteEpargneRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompteEpargneServiceImpl implements CompteEpargneService {
    private final CompteEpargneRepository repository;
    private final CompteEpargneMapper mapper;
    private final ClientRepository clientRepository;


    @PostConstruct
    private void initDb() {

        repository.saveAll(List.of(
        ));
    }
    @Override
    public List<CompteEpargneDto> findAll()
    {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<CompteEpargneDto> getCompteById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public CompteEpargneDto save(long ownerId, CompteEpargneCreateDto dto) {
        Optional<Client> client = clientRepository.findById(ownerId);
        if ((client.isEmpty()) || (client.get().getEpargneCompte() == -1))
        {return null;}


        CompteEpargneEntity entity = mapper.ToEntity(dto);
        entity = repository.save(entity);
        client.get().setEpargneCompte(entity.getId());
        return mapper.toDto(entity);
    }

    @Override
    public Optional<CompteEpargneDto> update(Long id, CompteEpargneUpdateDto dto) {
        return repository.findById(id).map(
                existingCompteEpargne ->{ mapper.updateEntity(existingCompteEpargne, dto);
                return mapper.toDto(repository.save(existingCompteEpargne));}
        );
    }

    @Override
    public Optional<CompteEpargneDto> updateMoney(Long id, double money) {
        return repository.findById(id).map(
                existingCompteEpargne ->
                {
                    if(existingCompteEpargne.getSolde() + money >= 0)
                    {
                        existingCompteEpargne.setSolde(existingCompteEpargne.getSolde() + money);
                        //mapper.updateEntity(existingCompteEpargne, existingCompteEpargne);
                        return mapper.toDto(repository.save(existingCompteEpargne));
                    }
                    else
                    {return null;}
                }

        );
    }

    @Override
    public Boolean delete(Long id) {
        return repository.findById(id).map(existingCompteEpargne -> {repository.delete(existingCompteEpargne);
            return true;
        }).orElse(false);

    }

}
