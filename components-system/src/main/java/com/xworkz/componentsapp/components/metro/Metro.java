package com.xworkz.componentsapp.components.metro;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Metro {

    @Value("1")
    private int metroId;
    @Value("Green")
    private String line;
}
