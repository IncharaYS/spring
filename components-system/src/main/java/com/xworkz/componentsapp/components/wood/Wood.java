package com.xworkz.componentsapp.components.wood;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Wood {

    @Value("3")
    private int id;
    @Value("Red wood")
    private String type;
}
