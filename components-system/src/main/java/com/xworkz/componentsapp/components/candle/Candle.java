package com.xworkz.componentsapp.components.candle;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Candle {

    @Value("1")
    private int candleId;
    @Value("Bellavita")
    private String candleBrand;
}
