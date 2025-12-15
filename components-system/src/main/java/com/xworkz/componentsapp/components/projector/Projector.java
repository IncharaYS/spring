package com.xworkz.componentsapp.components.projector;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Projector {
    @Value("3")
    private int id;
    @Value("Epson")
    private String name;
}
