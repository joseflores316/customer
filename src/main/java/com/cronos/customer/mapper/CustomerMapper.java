package com.cronos.customer.mapper;


import com.cronos.customer.dto.CustomerDto;
import com.cronos.customer.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toEntity(CustomerDto customerDto);

    CustomerDto toDto(CustomerEntity customerEntity);
}
