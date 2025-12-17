package com.xworkz.medicalStoreApp.repository;

import com.xworkz.medicalStoreApp.dto.CustomerDTO;

public interface MedicalStoreRepository {
    boolean save(CustomerDTO customerDTO);
}
