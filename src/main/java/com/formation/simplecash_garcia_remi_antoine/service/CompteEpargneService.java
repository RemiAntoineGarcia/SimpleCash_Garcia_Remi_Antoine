package com.formation.simplecash_garcia_remi_antoine.service;

import com.formation.simplecash_garcia_remi_antoine.dto.*;

import java.util.List;
import java.util.Optional;

public interface CompteEpargneService {
    List<CompteEpargneDto> findAll();

    Optional<CompteEpargneDto> getCompteById(Long id);
    CompteEpargneDto save(long OwnerId, CompteEpargneCreateDto dto);
    Optional<CompteEpargneDto> update(Long id, CompteEpargneUpdateDto dto);
    Optional<CompteEpargneDto> updateMoney(Long id, double money);
    Boolean delete(Long id);
}
