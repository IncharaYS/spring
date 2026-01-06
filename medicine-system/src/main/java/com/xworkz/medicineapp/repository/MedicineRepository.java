package com.xworkz.medicineapp.repository;

import com.xworkz.medicineapp.dto.MedicineDTO;

import java.util.Optional;

public interface MedicineRepository {
    boolean save(MedicineDTO medicineDTO);

    Optional<MedicineDTO> searchByName(String medicineName);
    Optional<MedicineDTO> searchById(int id);
}
