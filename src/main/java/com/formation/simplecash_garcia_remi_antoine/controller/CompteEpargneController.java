package com.formation.simplecash_garcia_remi_antoine.controller;

import com.formation.simplecash_garcia_remi_antoine.dto.CompteEpargneCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteEpargneDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteEpargneUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.service.CompteEpargneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CompteEpargne")
@RequiredArgsConstructor
public class CompteEpargneController {
    private final CompteEpargneService compteEpargneService;
    @GetMapping
    public List<CompteEpargneDto> getAllCompteEpargneData()
    {
        return compteEpargneService.findAll();
    }
    @GetMapping("{id}")
    public CompteEpargneDto getAllCompteEpargneDataById(@PathVariable @Valid Long id)
    {
        return compteEpargneService.getCompteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @PostMapping
    public CompteEpargneDto save(long OwnerId,@Valid CompteEpargneCreateDto dto)
    {return compteEpargneService.save(OwnerId,dto);}

    @PatchMapping("{id}")
    public ResponseEntity<CompteEpargneDto> updateCompteEpargne(@PathVariable @Valid Long id,@RequestBody @Valid CompteEpargneUpdateDto dto)
    {
        return compteEpargneService.update(id,dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("MoveMoney/{id}")
    public ResponseEntity<CompteEpargneDto> MoveMoney(@PathVariable @Valid Long id,@RequestBody @Valid double value)
    {
        return compteEpargneService.updateMoney(id,value)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCompteEpargne(@PathVariable @Valid Long id)
    {
        if(compteEpargneService.delete(id))
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
