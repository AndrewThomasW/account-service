package com.andrew.nsimbi.accountservice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String accountHolderName;
    private String emailAddress;
    private String phoneNumber;

    //Account Id
    private BigDecimal accountNumber;
}
