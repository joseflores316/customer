//package com.cronos.customer.controller;
//
//import com.cronos.customer.builder.CustomerObjectMother;
//import com.cronos.customer.infraestructure.rest.controller.CustomerController;
//import com.cronos.customer.application.service.CustomerService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(CustomerController.class)
//class CustomerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CustomerService customerService;
//
//    @Test
//    void getCustomers() throws Exception {
//
//        //Given
//        when(customerService.findAll()).thenReturn(CustomerObjectMother.ANY_LIST_DTO);
//
//        //When
//        mockMvc.perform(get("/api/customer").contentType(MediaType.APPLICATION_JSON))
//        //Then
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].name").value("jose"))
//                .andExpect(jsonPath("$[0].surname").value("aylas"));
//
//        verify(customerService, times(1)).findAll();
//
//    }
//
//    @Test
//    void getCustomerById() throws Exception {
//
//        //Given
//        when(customerService.findById(1L)).thenReturn(CustomerObjectMother.ANY_DTO);
//
//        //When
//        mockMvc.perform(get("/api/customer/1").contentType(MediaType.APPLICATION_JSON))
//        //Then
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.name").value("jose"))
//                .andExpect(jsonPath("$.surname").value("aylas"));
//
//        verify(customerService, times(1)).findById(1L);
//
//    }
//}