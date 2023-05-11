package com.cronos.customer.infraestructure.rest.mapper;


import com.cronos.customer.infraestructure.entity.CustomerEntity;
import com.cronos.customer.domain.models.CustomerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toEntity(CustomerDto customerDto);

    CustomerDto toDto(CustomerEntity customerEntity);

    List<CustomerDto> toDtoList(List<CustomerEntity> customerEntity);

    List<CustomerEntity> toEntityList(List<CustomerDto> customerDto);


}
