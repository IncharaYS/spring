package com.xworkz.componentsapp.components.bag;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Bag {

    @Value("1")
    private int bagId;
    @Value("Skybags")
    private String bagBrand;
}
