package com.formation.simplecash_garcia_remi_antoine.controller;

import com.formation.simplecash_garcia_remi_antoine.dto.CompteCourantCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteCourantDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteCourantUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.service.CompteCourantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CompteCourant")
@RequiredArgsConstructor
public class CompteCourantController {
    private final CompteCourantService compteCourantService;
    @GetMapping
    public List<CompteCourantDto> getAllCompteCourantData()
    {
        return compteCourantService.findAll();
    }
    @GetMapping("{id}")
    public CompteCourantDto getAllCompteCourantDataById(@PathVariable @Valid Long id)
    {
        return compteCourantService.getCompteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @PostMapping
    public CompteCourantDto save(long OwnerId, @Valid CompteCourantCreateDto dto)
    {return compteCourantService.save(OwnerId, dto);}

    @PatchMapping("{id}")
    public ResponseEntity<CompteCourantDto> updateCompteCourant(@PathVariable @Valid Long id,@RequestBody @Valid CompteCourantUpdateDto dto)
    {
        return compteCourantService.update(id,dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("MoveMoney/{id}")
    public ResponseEntity<CompteCourantDto> MoveMoney(@PathVariable @Valid Long id,@RequestBody @Valid double value)
    {
        return compteCourantService.updateMoney(id,value)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCompteCourant(@PathVariable @Valid Long id)
    {
        if(compteCourantService.delete(id))
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
