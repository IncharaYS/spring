package com.xworkz.componentsapp.components.table;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Table {

    @Value("1")
    private int tableId;
    @Value("Savitha")
    private String tableBrand;
}
