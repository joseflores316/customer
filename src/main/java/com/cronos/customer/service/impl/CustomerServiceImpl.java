package com.cronos.customer.service.impl;

import com.cronos.customer.EntityValidatorHelper;
import com.cronos.customer.dto.CustomerDto;
import com.cronos.customer.entity.CustomerEntity;
import com.cronos.customer.mapper.CustomerMapper;
import com.cronos.customer.repository.CustomerRepository;
import com.cronos.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream().map(customerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDto findById(Long id) {
        return customerMapper.toDto(EntityValidatorHelper.validateIfExistsAndReturn(customerRepository, id));
    }

    @Override
    @Transactional
    public CustomerDto create(CustomerDto customerDto) {
        return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(customerDto)));
    }

    @Override
    @Transactional
    public CustomerDto update(Long id, CustomerDto customerDto) {
         CustomerEntity customerEntity = EntityValidatorHelper.validateIfExistsAndReturn(customerRepository, id);
         customerDto.setId(customerEntity.getId());
         return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(customerDto)));

    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        CustomerEntity customerEntity = EntityValidatorHelper.validateIfExistsAndReturn(customerRepository, id);
        customerRepository.deleteById(customerEntity.getId());
        return Boolean.TRUE;
    }
}
