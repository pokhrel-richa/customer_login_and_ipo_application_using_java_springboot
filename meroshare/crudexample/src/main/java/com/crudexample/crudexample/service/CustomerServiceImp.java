package com.crudexample.crudexample.service;

import com.crudexample.crudexample.dto.CustomerRequest;
import com.crudexample.crudexample.dto.CustomerResponse;
import com.crudexample.crudexample.entity.Customer;
import com.crudexample.crudexample.entity.UserToken;
import com.crudexample.crudexample.repository.CustomerRepository;
import com.crudexample.crudexample.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserTokenRepository userTokenRepository;
    public String createCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setActive(customerRequest.getActive());
        customer.setAccountNumber(customerRequest.getAccountNumber());
        customer.setDematNumber(customerRequest.getDematNumber());
        customer.setDpNumber(customerRequest.getDpNumber());
        customer.setUsername(customerRequest.getUsername());
        customer.setPassword(customerRequest.getPassword());
        customerRepository.save(customer);
        return "Customer Saved Successfully";
    }
    public String updateCustomer(CustomerRequest customerRequest, long id){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null){
            return "Cannot Find The Customer";
        }
        customer.setName(customerRequest.getName());
        customer.setActive(customerRequest.getActive());
        customer.setAccountNumber(customerRequest.getAccountNumber());
        customer.setDematNumber(customerRequest.getDematNumber());
        customer.setDpNumber(customerRequest.getDpNumber());
        customer.setUsername(customerRequest.getUsername());
        customer.setPassword(customerRequest.getPassword());
        customerRepository.save(customer);
        return "Customer Updated Successfully";
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();
        customers.forEach(customer->{
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setName(customer.getName());
            customerResponse.setActive(customer.getActive());
            customerResponse.setAccountNumber(customer.getAccountNumber());
            customerResponse.setDematNumber(customer.getDematNumber());
            customerResponse.setDpNumber(customer.getDpNumber());
            customerResponses.add(customerResponse);
        });
        return customerResponses;
    }

    @Override
    public String login(CustomerRequest customerRequest) {
        Customer customer = customerRepository.findByUsernameAndPasswordAndDpNumber(customerRequest.getUsername(),customerRequest.getPassword(),customerRequest.getDpNumber());
        if(customer == null){
            return "Invalid Login Details";
        }
        String random = RandomString.getAlphaNumericString(8);
        UserToken userToken = new UserToken();
        userToken.setToken(random);
        userToken.setCustomer(customer);
        userTokenRepository.save(userToken);
        return "Customer Validated Successfully!! \nGenerated Token is "+random;
    }
}
