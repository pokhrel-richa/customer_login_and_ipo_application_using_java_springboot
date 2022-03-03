package com.crudexample.crudexample.service;

import com.crudexample.crudexample.dto.IPORequest;

import java.util.List;

public interface IPOService {
    public String createIPO(IPORequest ipoRequest);
    public String updateIPO(IPORequest ipoRequest, long id);
    public List<IPORequest> getIPOs();

}
