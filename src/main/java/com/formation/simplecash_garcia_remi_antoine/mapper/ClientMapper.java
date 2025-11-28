package com.formation.simplecash_garcia_remi_antoine.mapper;

import com.formation.simplecash_garcia_remi_antoine.dto.ClientCreateDto;
import com.formation.simplecash_garcia_remi_antoine.dto.ClientDataDto;
import com.formation.simplecash_garcia_remi_antoine.dto.ClientUpdateDto;
import com.formation.simplecash_garcia_remi_antoine.entity.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClientMapper {
    ClientDataDto toDto(Client client);

    @Mapping(target = "id", ignore = true)
    Client ToEntity(ClientCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Client entity, ClientUpdateDto dto);
}
