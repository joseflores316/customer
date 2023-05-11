//package com.cronos.customer.service.impl;
//
//import com.cronos.customer.builder.CustomerObjectMother;
//import com.cronos.customer.domain.models.CustomerDto;
//import com.cronos.customer.infraestructure.entity.CustomerEntity;
//import com.cronos.customer.infraestructure.rest.mapper.CustomerMapper;
//import com.cronos.customer.domain.ports.CustomerRepository;
//import com.cronos.customer.application.service.CustomerService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class CustomerServiceImplTest {
//
//    @MockBean
//    CustomerRepository customerRepository;
//
//    @MockBean
//    CustomerMapper customerMapper;
//
//    @Autowired
//    CustomerService customerService;
//
//    @Test
//    void findAll() {
//
//        when(customerRepository.findAll()).thenReturn(CustomerObjectMother.ANY_LIST_ENTITY);
//        when(customerMapper.toDto(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_DTO);
//
//        assertEquals(CustomerObjectMother.ANY_LIST_DTO,customerService.findAll());
//    }
//
//    @Test
//    void findById() {
//
//        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(CustomerObjectMother.ANY_ENTITY));
//        when(customerMapper.toDto(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_DTO);
//
//        assertEquals(CustomerObjectMother.ANY_DTO,customerService.findById(1L));
//    }
//
//    @Test
//    void create() {
//
//        when(customerMapper.toEntity(any(CustomerDto.class))).thenReturn(CustomerObjectMother.ANY_ENTITY);
//        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_ENTITY);
//        when(customerMapper.toDto(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_DTO);
//
//        assertEquals(CustomerObjectMother.ANY_DTO,customerService.create(CustomerObjectMother.ANY_DTO));
//    }
//
//    @Test
//    void update() {
//
//        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(CustomerObjectMother.ANY_ENTITY));
//        when(customerMapper.toEntity(any(CustomerDto.class))).thenReturn(CustomerObjectMother.ANY_ENTITY);
//        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_ENTITY);
//        when(customerMapper.toDto(any(CustomerEntity.class))).thenReturn(CustomerObjectMother.ANY_DTO);
//
//
//        assertEquals(CustomerObjectMother.ANY_DTO,customerService.update(1L,CustomerObjectMother.ANY_DTO));
//    }
//
//    @Test
//    void delete() {
//
//        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(CustomerObjectMother.ANY_ENTITY));
//
//        doNothing().when(customerRepository).deleteById(CustomerObjectMother.ANY_ENTITY.getId());
//
//        customerService.delete(1L);
//
//        verify(customerRepository).deleteById(1L);
//    }
//}