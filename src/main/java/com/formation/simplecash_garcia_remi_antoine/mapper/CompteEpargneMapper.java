package com.formation.simplecash_garcia_remi_antoine.mapper;

import com.formation.simplecash_garcia_remi_antoine.dto.CompteEpargneCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteEpargneDto;
import com.formation.simplecash_garcia_remi_antoine.dto.CompteEpargneUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.entity.CompteEpargneEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CompteEpargneMapper {
    CompteEpargneDto toDto(CompteEpargneEntity CompteEpargne);

    @Mapping(target = "id", ignore = true)
    CompteEpargneEntity ToEntity(CompteEpargneCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "solde", ignore = true)
    void updateEntity(@MappingTarget CompteEpargneEntity entity, CompteEpargneUpdateDto dto);
}
