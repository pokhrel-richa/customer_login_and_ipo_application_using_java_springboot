package com.crudexample.crudexample.repository;

import com.crudexample.crudexample.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUsernameAndPasswordAndDpNumber(String username, String password, String dpNumber);
}
