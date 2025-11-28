package com.formation.simplecash_garcia_remi_antoine.mapper;

import com.formation.simplecash_garcia_remi_antoine.dto.*;
import com.formation.simplecash_garcia_remi_antoine.entity.Client;
import com.formation.simplecash_garcia_remi_antoine.entity.CompteCourantEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CompteCourantMapper {
    CompteCourantDto toDto(CompteCourantEntity CompteCourant);

    @Mapping(target = "id", ignore = true)
    CompteCourantEntity ToEntity(CompteCourantCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "solde", ignore = true)
    void updateEntity(@MappingTarget CompteCourantEntity entity, CompteCourantUpdateDto dto);
}
