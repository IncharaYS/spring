package com.xworkz.componentsapp.components.hotel;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Hotel {

    @Value("3")
    private int hostelId;
    @Value("Canara")
    private String hotelName;
}
