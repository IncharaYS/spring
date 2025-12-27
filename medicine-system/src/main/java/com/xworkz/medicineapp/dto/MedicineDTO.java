package com.xworkz.medicineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDTO {

    private String medicineName;
    private String price;
    private String mg;
    private String combination;
    private String expDate;

}
