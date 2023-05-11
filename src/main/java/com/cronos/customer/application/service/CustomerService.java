package com.cronos.customer.application.service;

import com.cronos.customer.domain.models.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto create(CustomerDto customerDto);

    CustomerDto findById(Long id);

    void deleteById(Long id);

    List<CustomerDto> findAll();

    CustomerDto update(Long id, CustomerDto customerDto);
}
