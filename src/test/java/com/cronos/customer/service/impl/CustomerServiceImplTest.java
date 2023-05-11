package com.cronos.customer.service.impl;

import com.cronos.customer.application.service.CustomerService;
import com.cronos.customer.builder.CustomerObjectMother;
import com.cronos.customer.domain.models.CustomerDto;
import com.cronos.customer.infraestructure.adaptador.CustomerJpaRepositoryMySQL;
import com.cronos.customer.infraestructure.entity.CustomerEntity;
import com.cronos.customer.infraestructure.rest.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceImplTest {

    @MockBean
    CustomerJpaRepositoryMySQL customerJpaRepositoryMySQL;

    @MockBean
    CustomerMapper customerMapper;

    @Autowired
    CustomerService customerService;

    @Test
    void findAll() {

        when(customerJpaRepositoryMySQL.findAll()).thenReturn(CustomerObjectMother.ANY_LIST_ENTITY);
        when(customerMapper.toDto(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_DTO);
        when(customerMapper.toDtoList(anyList())).thenReturn(CustomerObjectMother.ANY_LIST_DTO);

        assertEquals(CustomerObjectMother.ANY_LIST_DTO,customerService.findAll());
    }

    @Test
    void findById() {

        when(customerJpaRepositoryMySQL.findById(1L)).thenReturn(Optional.ofNullable(CustomerObjectMother.ANY_ENTITY));
        when(customerMapper.toDto(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_DTO);

        assertEquals(CustomerObjectMother.ANY_DTO,customerService.findById(1L));
    }

    @Test
    void create() {

        when(customerMapper.toEntity(any(CustomerDto.class))).thenReturn(CustomerObjectMother.ANY_ENTITY);
        when(customerJpaRepositoryMySQL.save(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_ENTITY);
        when(customerMapper.toDto(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_DTO);

        assertEquals(CustomerObjectMother.ANY_DTO,customerService.create(CustomerObjectMother.ANY_DTO));
    }

    @Test
    void update() {

        when(customerJpaRepositoryMySQL.findById(1L)).thenReturn(Optional.ofNullable(CustomerObjectMother.ANY_ENTITY));
        when(customerMapper.toEntity(any(CustomerDto.class))).thenReturn(CustomerObjectMother.ANY_ENTITY);
        when(customerJpaRepositoryMySQL.save(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_ENTITY);
        when(customerMapper.toDto(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_DTO);


        assertEquals(CustomerObjectMother.ANY_DTO,customerService.update(1L,CustomerObjectMother.ANY_DTO));
    }

    @Test
    void delete() {

        when(customerJpaRepositoryMySQL.findById(1L)).thenReturn(Optional.ofNullable(CustomerObjectMother.ANY_ENTITY));

        doNothing().when(customerJpaRepositoryMySQL).deleteById(1L);

        customerService.deleteById(1L);

        verify(customerJpaRepositoryMySQL).deleteById(1L);
    }
}