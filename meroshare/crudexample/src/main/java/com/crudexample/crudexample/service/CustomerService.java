package com.crudexample.crudexample.service;

import com.crudexample.crudexample.dto.CustomerRequest;
import com.crudexample.crudexample.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

   public String createCustomer(CustomerRequest customerRequest);
   public String updateCustomer(CustomerRequest customerRequest, long id);
   public List<CustomerResponse> getAllCustomers();
   public String login(CustomerRequest customerRequest);
}
