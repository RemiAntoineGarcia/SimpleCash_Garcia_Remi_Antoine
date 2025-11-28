package com.formation.simplecash_garcia_remi_antoine.service;

import com.formation.simplecash_garcia_remi_antoine.dto.CompteCourantCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteCourantUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteCourantDto;

import java.util.List;
import java.util.Optional;

public interface CompteCourantService {
    List<CompteCourantDto> findAll();

    Optional<CompteCourantDto> getCompteById(Long id);
    CompteCourantDto save(long OwnerId,CompteCourantCreateDto dto);
    Optional<CompteCourantDto> update(Long id, CompteCourantUpdateDto dto);
    Optional<CompteCourantDto> updateMoney(Long id, double money);
    Boolean delete(Long id);
}
