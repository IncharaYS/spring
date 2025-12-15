package com.xworkz.componentsapp.components.headphone;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class HeadPhone {

    @Value("1")
    private int id;
    @Value("Boat")
    private String brand;
}
