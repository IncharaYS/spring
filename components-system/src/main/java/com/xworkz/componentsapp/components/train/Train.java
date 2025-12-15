package com.xworkz.componentsapp.components.train;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Train {

    @Value("1")
    private int trainId;
    @Value("Siddaganga express")
    private String trainName;
}
