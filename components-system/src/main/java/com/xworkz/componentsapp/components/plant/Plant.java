package com.xworkz.componentsapp.components.plant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Plant {

    @Value("3")
    private int plantId;
    @Value("Money plant")
    private String plantName;
}
