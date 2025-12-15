package com.xworkz.componentsapp.components.bank;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Bank {
    @Value("1")
    private int id;
    @Value("SBI")
    private String bankName;
    @Value("Banglore")
    private String Address;
}
