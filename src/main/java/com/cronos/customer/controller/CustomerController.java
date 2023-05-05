package com.cronos.customer.controller;

import com.cronos.customer.dto.CustomerDto;
import com.cronos.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
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
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.delete(id), HttpStatus.OK);
    }
    //cosas a borrar
    

}
