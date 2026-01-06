package com.xworkz.medicineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicine")
public class MedicineDTO {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "medicine_name")
    private String medicineName;

    @Column(name = "price")
    private String price;

    @Column(name = "mg")
    private String mg;

    @Column(name = "combination")
    private String combination;

    @Column(name = "exp_date")
    private String expDate;

}
