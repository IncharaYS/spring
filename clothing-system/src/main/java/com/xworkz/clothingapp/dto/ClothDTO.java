package com.xworkz.clothingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothDTO implements Serializable {

    private int clothId;
    @NotBlank
    @Size(min=3,message = "Invalid cloth name")
    private String clothName;
    @NotBlank
    @Size(min=3,message = "Invalid cloth brand name")
    private String brandName;
    private String categoryName;
    private String size;
    private String color;
    private double price;
    private int stockQuantity;
    private String availabilityStatus;
    private int isDeleted;
}
