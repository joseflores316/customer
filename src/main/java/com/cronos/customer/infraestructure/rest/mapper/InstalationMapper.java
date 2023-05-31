package com.cronos.customer.infraestructure.rest.mapper;

import com.cronos.customer.domain.models.InstalationDto;
import com.cronos.customer.infraestructure.entity.InstalationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstalationMapper {

     InstalationEntity toEntity(InstalationDto instalationDto);

     InstalationDto toDto(InstalationEntity instalationEntity);

     List<InstalationDto> toDtoList(List<InstalationEntity> instalationEntity);

     List<InstalationEntity> toEntityList(List<InstalationDto> instalationDto);
}
