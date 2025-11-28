package com.formation.simplecash_garcia_remi_antoine.mapper;

import com.formation.simplecash_garcia_remi_antoine.dto.ClientDataDto;
import com.formation.simplecash_garcia_remi_antoine.entity.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ClientMapper {
    ClientDataDto toDto(Client client);

    //Client ToEntity(ClientDataDto dto);

}
