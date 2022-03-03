package com.crudexample.crudexample.controller;

import com.crudexample.crudexample.dto.CustomerRequest;
import com.crudexample.crudexample.dto.CustomerResponse;
import com.crudexample.crudexample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //creates new customer
    @PostMapping("/create")
    public String createCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.createCustomer(customerRequest);
    }
    //updates existing customer with a given id
    @PutMapping("/update/{id}")
    public String updateCustomer(@RequestBody CustomerRequest customerRequest,@PathVariable String id){
        return customerService.updateCustomer(customerRequest,Long.parseLong(id));
    }
    //get all the customers
    @GetMapping("/customers")
    public List<CustomerResponse> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }
    @PostMapping("/login")
    public String loginCustomer(@RequestBody CustomerRequest customerRequest)
    {
        return customerService.login(customerRequest);
    }


}
