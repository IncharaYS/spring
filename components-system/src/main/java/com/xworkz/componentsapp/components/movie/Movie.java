package com.xworkz.componentsapp.components.movie;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Movie {

    @Value("8")
    private int id;
    @Value("Kanthara")
    private String name;
}
