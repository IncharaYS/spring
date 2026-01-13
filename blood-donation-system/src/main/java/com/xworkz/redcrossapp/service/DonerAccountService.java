package com.xworkz.redcrossapp.service;

import com.xworkz.redcrossapp.dto.DonerDTO;
import com.xworkz.redcrossapp.dto.SearchDTO;

import java.util.Optional;

public interface DonerAccountService {

    boolean validateAndSave(DonerDTO donerDTO);
    Optional<DonerDTO> validateAndSearchByEmail(String email);
    boolean updateDoner(DonerDTO donerDTO);
    boolean deleteByEmail(String email);
    boolean deleteById(int id);

}
