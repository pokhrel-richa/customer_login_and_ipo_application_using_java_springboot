package com.crudexample.crudexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class IpoApplyRequestDTO {
    private String token;
    private int applyQuantity;
    private  String code;
    private List<CustomerRequest> customerRequests;

}
