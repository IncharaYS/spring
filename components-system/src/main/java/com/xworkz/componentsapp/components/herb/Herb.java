package com.xworkz.componentsapp.components.herb;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Herb {
    @Value("6")
    private int id;
    @Value("Rosemary")
    private String name;
}
