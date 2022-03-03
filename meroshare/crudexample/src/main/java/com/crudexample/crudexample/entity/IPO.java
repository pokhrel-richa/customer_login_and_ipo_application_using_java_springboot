package com.crudexample.crudexample.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
//B. IPO 			[ID,NAME,CODE,ISSUE_QUANTITY,MAX_LIMIT,MIN_LIMIT]
public class IPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String code;
    private int issueQuantity;
    private int maxLimit;
    private int minLimit;

}
