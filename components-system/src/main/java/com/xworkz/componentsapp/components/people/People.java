package com.xworkz.componentsapp.components.people;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class People {

    @Value("1")
    private int personId;
    @Value("Inchara")
    private String personName;
}
