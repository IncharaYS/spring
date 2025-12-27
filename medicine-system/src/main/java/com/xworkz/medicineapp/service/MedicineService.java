package com.xworkz.medicineapp.service;

import com.xworkz.medicineapp.dto.MedicineDTO;

import java.util.Optional;

public interface MedicineService {

    boolean validateAndSave(MedicineDTO medicineDTO);

    Optional<MedicineDTO> getMedicine(String medicineName);
}
