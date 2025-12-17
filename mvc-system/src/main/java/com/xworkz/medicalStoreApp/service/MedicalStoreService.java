package com.xworkz.medicalStoreApp.service;

import com.xworkz.medicalStoreApp.dto.CustomerDTO;

public interface MedicalStoreService {

    boolean validateAndSave(CustomerDTO customerDTO);
}
