package com.cronos.customer.domain.ports;

import com.cronos.customer.infraestructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
