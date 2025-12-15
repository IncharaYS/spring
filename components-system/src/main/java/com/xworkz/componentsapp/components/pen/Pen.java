package com.xworkz.componentsapp.components.pen;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pen {

    @Value("2")
    private int penId;
    @Value("Sigma")
    private String brand;
}
