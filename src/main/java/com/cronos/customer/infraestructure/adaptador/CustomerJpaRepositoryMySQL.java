package com.cronos.customer.infraestructure.adaptador;

import com.cronos.customer.infraestructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepositoryMySQL extends JpaRepository<CustomerEntity,Long> {
}
