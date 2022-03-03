package com.crudexample.crudexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CustomerResponse {
    private String name;
    private Character active;
    private String dematNumber;
    private String accountNumber;
    private String dpNumber;
}
