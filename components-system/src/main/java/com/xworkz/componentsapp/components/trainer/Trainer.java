package com.xworkz.componentsapp.components.trainer;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Trainer {
    @Value("7")
    private int id;
    @Value("Dev")
    private String name;
}
