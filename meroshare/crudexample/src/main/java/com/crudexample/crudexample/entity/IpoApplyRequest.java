package com.crudexample.crudexample.entity;

// C. IPO_APPLY_REQUEST 	[ID,IPO_ID,APPLY_QUANTITY,CUSTOMER_ID]

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
//C. IPO_APPLY_REQUEST 	[ID,IPO_ID,APPLY_QUANTITY,CUSTOMER_ID]
public class IpoApplyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int applyQuantity;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "ipo_id")
    private IPO ipo;

}
