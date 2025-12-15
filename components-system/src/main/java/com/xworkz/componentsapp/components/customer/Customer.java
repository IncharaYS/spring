package com.xworkz.componentsapp.components.customer;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Customer {
    @Value("1")
    private int customerId;
    @Value("Inchara")
    private String customerName;
}
