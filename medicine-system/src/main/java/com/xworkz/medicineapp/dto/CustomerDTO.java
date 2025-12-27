package com.xworkz.medicineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String fullNamee;
    private String email;
    private int age;
    private String gender;

}
