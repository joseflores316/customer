package com.cronos.customer.service;

import com.cronos.customer.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> findAll();

    CustomerDto findById(Long id);

    CustomerDto create(CustomerDto customerDto);

    CustomerDto update(Long id, CustomerDto customerDto);

    Boolean delete(Long id);
}
