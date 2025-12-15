package com.xworkz.componentsapp.components.institute;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Institute {

    @Value("1")
    private int instituteId;
    @Value("X-workz")
    private String instituteName;
}
