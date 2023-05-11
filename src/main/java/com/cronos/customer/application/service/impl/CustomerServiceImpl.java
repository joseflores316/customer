package com.cronos.customer.application.service.impl;

import com.cronos.customer.application.service.CustomerService;
import com.cronos.customer.domain.models.CustomerDto;
import com.cronos.customer.domain.ports.CustomerRepository;
import com.cronos.customer.infraestructure.entity.CustomerEntity;
import com.cronos.customer.infraestructure.helper.EntityValidatorHelper;
import com.cronos.customer.infraestructure.rest.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
