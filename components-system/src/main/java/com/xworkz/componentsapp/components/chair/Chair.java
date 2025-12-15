package com.xworkz.componentsapp.components.chair;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Chair {
    @Value("1")
    private int chairId;
    @Value("Sonic")
    private String brandName;
}
