package com.xworkz.matrimonyApp.service;

import com.xworkz.matrimonyApp.dto.MatrimonyDTO;

public interface MatrimonyService {

    boolean validateAndSave(MatrimonyDTO matrimonyDTO);
}
