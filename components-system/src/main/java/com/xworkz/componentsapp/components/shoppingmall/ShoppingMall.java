package com.xworkz.componentsapp.components.shoppingmall;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ShoppingMall {

    @Value("2")
    private int id;
    @Value("Orion")
    private String name;
}
