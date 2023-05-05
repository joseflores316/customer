package com.cronos.customer.builder;

import com.cronos.customer.dto.CustomerDto;

import java.util.Arrays;
import java.util.List;

public class CustomerObjectMother {

    public static final CustomerDto ANY = aCustomerDto();
    public static final List<CustomerDto> ANY_LIST = aListCustomerDto();


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
