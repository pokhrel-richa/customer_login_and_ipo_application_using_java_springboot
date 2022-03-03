package com.crudexample.crudexample.controller;

import com.crudexample.crudexample.dto.IPORequest;
import com.crudexample.crudexample.service.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IPOController {
    @Autowired
    private IPOService ipoService;
    @PostMapping("/ipo")
    public String createIPO(@RequestBody IPORequest ipoRequest){
       return ipoService.createIPO(ipoRequest);
    }
    @PutMapping("/ipo/update/{id}")
    public String updateIPO(@RequestBody IPORequest ipoRequest, @PathVariable String id){
        return ipoService.updateIPO(ipoRequest,Long.parseLong(id));

    }

    @GetMapping("/ipos")
    public List<IPORequest> getALLIpos(){
        return ipoService.getIPOs();
    }

}
