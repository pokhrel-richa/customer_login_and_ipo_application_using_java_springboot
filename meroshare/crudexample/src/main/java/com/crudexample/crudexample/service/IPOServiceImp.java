package com.crudexample.crudexample.service;

import com.crudexample.crudexample.dto.IPORequest;
import com.crudexample.crudexample.entity.IPO;
import com.crudexample.crudexample.repository.IPORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IPOServiceImp implements IPOService {
    @Autowired
    private IPORepository ipoRepository;
    public String createIPO(IPORequest ipoRequest){
        IPO ipo = new IPO();
        ipo.setCode(ipoRequest.getCode());
        ipo.setIssueQuantity(ipoRequest.getIssueQuantity());
        ipo.setMaxLimit(ipoRequest.getMaxLimit());
        ipo.setName(ipoRequest.getName());
        ipo.setMinLimit(ipoRequest.getMinLimit());
        ipoRepository.save(ipo);
        return "Successfully created";
    }

    @Override
    public String updateIPO(IPORequest ipoRequest, long id) {
        IPO ipo = ipoRepository.findById(id).orElse(null);
        ipo.setCode(ipoRequest.getCode());
        ipo.setIssueQuantity(ipoRequest.getIssueQuantity());
        ipo.setMaxLimit(ipoRequest.getMaxLimit());
        ipo.setName(ipoRequest.getName());
        ipo.setMinLimit(ipoRequest.getMinLimit());
        ipoRepository.save(ipo);
        return "Successfully updated";
    }

    @Override
    public List<IPORequest> getIPOs() {
        List<IPO> ipos = ipoRepository.findAll();
        List<IPORequest> ipoRequests = new ArrayList<>();
        ipos.forEach(e->{
            IPORequest ipoRequest = new IPORequest();
            ipoRequest.setName(e.getName());
            ipoRequest.setCode(e.getCode());
            ipoRequest.setIssueQuantity(e.getIssueQuantity());
            ipoRequest.setMaxLimit(e.getMaxLimit());
            ipoRequest.setMinLimit(e.getMinLimit());
            ipoRequests.add(ipoRequest);
        });
        return ipoRequests;
    }
}
