package com.xworkz.matrimonyApp.repository;

import com.xworkz.matrimonyApp.dto.MatrimonyDTO;

public interface MatrimonyRepository {
    boolean save(MatrimonyDTO matrimonyDTO);
}
