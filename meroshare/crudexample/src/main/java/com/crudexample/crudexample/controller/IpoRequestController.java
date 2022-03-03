package com.crudexample.crudexample.controller;

import com.crudexample.crudexample.dto.IpoApplyRequestDTO;
import com.crudexample.crudexample.service.IpoRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IpoRequestController {
    @Autowired
    private IpoRequestService ipoRequestService;

    @PostMapping("/apply")
    public String applyIpo(@RequestBody IpoApplyRequestDTO ipoApplyRequestDTO){
        return ipoRequestService.applyIpo(ipoApplyRequestDTO);
    }

}
