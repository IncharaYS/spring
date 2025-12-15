package com.xworkz.componentsapp.components.library;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Library {

    @Value("1")
    private int libraryId;
    @Value("Central library")
    private String libraryName;
}
