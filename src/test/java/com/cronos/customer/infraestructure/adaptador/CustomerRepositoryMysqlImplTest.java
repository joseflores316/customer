//package com.cronos.customer.infraestructure.adaptador;
//
//import com.cronos.customer.infraestructure.entity.CustomerEntity;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//class CustomerRepositoryMysqlImplTest {
//
//    @Autowired
//    private CustomerJpaRepositoryMySQL customerJpaRepositoryMySQL;
//
//
//    @Test
//    void testFindById() {
//        Optional<CustomerEntity> optionalCustomerEntity = customerJpaRepositoryMySQL.findById(2L);
//
//        assertTrue(optionalCustomerEntity.isPresent());
//        assertEquals("jose", optionalCustomerEntity.get().getName());
//    }
//
//}