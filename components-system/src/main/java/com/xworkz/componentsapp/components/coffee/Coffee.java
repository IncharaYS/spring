package com.xworkz.componentsapp.components.coffee;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Coffee {

    @Value("1")
    private int coffeeId;
    @Value("Bayars")
    private String coffeeBrand;
}
