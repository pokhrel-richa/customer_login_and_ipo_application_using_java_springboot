package com.crudexample.crudexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "userToken")
public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String token;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
