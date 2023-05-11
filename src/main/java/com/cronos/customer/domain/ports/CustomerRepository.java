package com.cronos.customer.domain.ports;

import com.cronos.customer.domain.models.CustomerDto;
import com.cronos.customer.infraestructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

        CustomerDto create(CustomerDto customerDto);

        CustomerDto findById(Long id);

        void deleteById(Long id);

        List<CustomerDto> findAll();

        CustomerDto update(Long id, CustomerDto customerDto);
}
