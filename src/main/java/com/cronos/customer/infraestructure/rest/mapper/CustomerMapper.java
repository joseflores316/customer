package com.cronos.customer.infraestructure.rest.mapper;


import com.cronos.customer.infraestructure.entity.CustomerEntity;
import com.cronos.customer.domain.models.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toEntity(CustomerDto customerDto);

    CustomerDto toDto(CustomerEntity customerEntity);
}
