package com.cronos.customer.builder;

import com.cronos.customer.domain.models.CustomerDto;
import com.cronos.customer.infraestructure.entity.CustomerEntity;

import java.util.Arrays;
import java.util.List;

public class CustomerObjectMother {

    public static final CustomerDto ANY_DTO = aCustomerDto();
    public static final List<CustomerDto> ANY_LIST_DTO = aListCustomerDto();

    public static final CustomerEntity ANY_ENTITY = aCustomerEntity();

    public static final List<CustomerEntity> ANY_LIST_ENTITY = aListCustomerEntity();

    private static List<CustomerEntity> aListCustomerEntity() {
        return Arrays.asList(aCustomerEntity());
    }

    private static CustomerEntity aCustomerEntity() {
        return CustomerEntity.builder()
                .id(1L)
                .name("jose")
                .surname("aylas")
                .build();
    }


    private static CustomerDto aCustomerDto() {
        return CustomerDto.builder()
                .id(1L)
                .name("jose")
                .surname("aylas")
                .build();
    }

    private static List<CustomerDto> aListCustomerDto() {
        return Arrays.asList(aCustomerDto());
    }


}
