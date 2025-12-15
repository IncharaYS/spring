package com.xworkz.componentsapp.components.bottle;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Bottle {

    @Value("1")
    private int id;
    @Value("Blue")
    private String color;
}
