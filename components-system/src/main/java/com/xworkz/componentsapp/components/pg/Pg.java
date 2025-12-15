package com.xworkz.componentsapp.components.pg;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pg {

    @Value("3")
    private int pgId;
    @Value("Priya")
    private String pgName;
}
