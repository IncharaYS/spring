package com.xworkz.componentsapp.components.laptop;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Laptop {

    @Value("1")
    private int id;
    @Value("Asus")
    private String brand;
}
