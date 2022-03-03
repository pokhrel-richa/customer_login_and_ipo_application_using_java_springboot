package com.crudexample.crudexample.service;

import com.crudexample.crudexample.dto.IpoApplyRequestDTO;
import com.crudexample.crudexample.entity.Customer;
import com.crudexample.crudexample.entity.IPO;
import com.crudexample.crudexample.entity.IpoApplyRequest;
import com.crudexample.crudexample.entity.UserToken;
import com.crudexample.crudexample.repository.CustomerRepository;
import com.crudexample.crudexample.repository.IPORepository;
import com.crudexample.crudexample.repository.IpoRequestRepository;
import com.crudexample.crudexample.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpoRequestServiceImp implements IpoRequestService {
    @Autowired
    private UserTokenRepository userTokenRepository;
    @Autowired
    private IPORepository ipoRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private IpoRequestRepository ipoRequestRepository;
    public String applyIpo(IpoApplyRequestDTO ipoApplyRequestDTO){
        IPO ipo = ipoRepository.findByCode(ipoApplyRequestDTO.getCode());
        UserToken userToken = userTokenRepository.findByToken(ipoApplyRequestDTO.getToken());
        Customer customer = customerRepository.findById(userToken.getCustomer().getId()).orElse(null);
         if(ipoRequestRepository.findByCid(customer.getId(),ipo.getId())!=null) {
             return "IPO already applied";
         }
        if(userToken == null){
            return "Incorrect User Token";
        }

        if(ipo == null){
            return "The Requested IPO code is unavailable";
        }
        if(ipo.getMinLimit() > ipoApplyRequestDTO.getApplyQuantity() || ipo.getMaxLimit() < ipoApplyRequestDTO.getApplyQuantity()){
            return "Applied Quantity must be in limit between:" + ipo.getMinLimit() + " to " + ipo.getMaxLimit();
        }
        if(ipoRequestRepository.count(ipo.getId())>=ipo.getIssueQuantity() +ipoApplyRequestDTO.getApplyQuantity() ){
           int rem = ipo.getIssueQuantity() - ipoRequestRepository.count(ipo.getId());
           if(rem==0){
               return "IPO already oversubscribed";
           }
            return "Entered amount is not available. \nTry applying less than or equal to :" + rem + "units" ;
        }

        IpoApplyRequest ipoApplyRequest = new IpoApplyRequest();
        ipoApplyRequest.setIpo(ipo);
        ipoApplyRequest.setApplyQuantity(ipoApplyRequestDTO.getApplyQuantity());
        ipoApplyRequest.setCustomer(userToken.getCustomer());
        ipoRequestRepository.save(ipoApplyRequest);
        return "IPO applied Successfully";

    }
}
