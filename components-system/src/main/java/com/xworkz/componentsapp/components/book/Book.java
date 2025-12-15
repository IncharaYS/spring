package com.xworkz.componentsapp.components.book;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Book {

    @Value("1")
    private int bookId;
    @Value("Love hypothesis")
    private String bookTitle;
}
