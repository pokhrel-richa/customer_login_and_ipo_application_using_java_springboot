package com.crudexample.crudexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class IPORequest {
    private String name;
    private String code;
    private int issueQuantity;
    private int maxLimit;
    private int minLimit;
}
