package com.xworkz.componentsapp.components.police;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Police {

    @Value("6")
    private int id;
    @Value("Sandeep")
    private String name;
}
