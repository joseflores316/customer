package com.cronos.customer.application.service.impl;

import com.cronos.customer.application.service.CustomerService;
import com.cronos.customer.domain.models.CustomerDto;
import com.cronos.customer.domain.ports.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        return this.customerRepository.create(customerDto);
    }

    @Override
    public CustomerDto findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDto> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public CustomerDto update(Long id, CustomerDto customerDto) {
        return this.customerRepository.update(id, customerDto);
    }
}
