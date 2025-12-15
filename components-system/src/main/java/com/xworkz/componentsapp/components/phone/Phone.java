package com.xworkz.componentsapp.components.phone;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Phone {

    @Value("1")
    private int phoneId;
    @Value("Redmi Note 11")
    private String phoneName;
}
