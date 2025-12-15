package com.xworkz.componentsapp.components.medicine;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Medicine {

    @Value("4")
    private int id;
    @Value("Dolo")
    private String name;
}
