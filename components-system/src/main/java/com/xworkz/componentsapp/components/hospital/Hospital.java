package com.xworkz.componentsapp.components.hospital;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Hospital {

    @Value("1")
    private int hospitalId;
    @Value("Apollo")
    private String hospitalName;
}
