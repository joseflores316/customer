package com.cronos.customer.infraestructure.rest.controller;

import com.cronos.customer.application.service.CustomerService;
import com.cronos.customer.domain.models.CustomerDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.findById(id),HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.create(customerDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id,@Valid @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.update(id, customerDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteById(id);
    }

}
