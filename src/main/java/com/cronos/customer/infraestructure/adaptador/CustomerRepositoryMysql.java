package com.cronos.customer.infraestructure.adaptador;

import com.cronos.customer.domain.models.CustomerDto;
import com.cronos.customer.domain.ports.CustomerRepository;
import com.cronos.customer.infraestructure.entity.CustomerEntity;
import com.cronos.customer.infraestructure.helper.EntityValidatorHelper;
import com.cronos.customer.infraestructure.rest.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Slf4j
public class CustomerRepositoryMysql implements CustomerRepository {
    private final CustomerJpaRepositoryMySQL customerJpaRepositoryMySQL;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerRepositoryMysql(CustomerJpaRepositoryMySQL customerJpaRepositoryMySQL) {
        this.customerJpaRepositoryMySQL = customerJpaRepositoryMySQL;
    }

    @Override
    @Transactional
    public CustomerDto create(CustomerDto customerDto) {
        return customerMapper.toDto(customerJpaRepositoryMySQL.save(customerMapper.toEntity(customerDto)));
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDto findById(Long id) {
        return customerMapper.toDto(EntityValidatorHelper.validateIfExistsAndReturn(customerJpaRepositoryMySQL, id));
    }

    @Override
    public void deleteById(Long id) {
        CustomerEntity customerEntity = EntityValidatorHelper.validateIfExistsAndReturn(customerJpaRepositoryMySQL, id);
        customerJpaRepositoryMySQL.deleteById(customerEntity.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> findAll() {
        return this.customerMapper.toDtoList(this.customerJpaRepositoryMySQL.findAll());
    }

    @Override
    @Transactional
    public CustomerDto update(Long id, CustomerDto customerDto) {
        CustomerEntity customerEntity = EntityValidatorHelper.validateIfExistsAndReturn(customerJpaRepositoryMySQL, id);
        customerDto.setId(customerEntity.getId());
        return customerMapper.toDto(customerJpaRepositoryMySQL.save(customerMapper.toEntity(customerDto)));
    }
}
