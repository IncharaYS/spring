package com.xworkz.redcrossapp.repository;

import com.xworkz.redcrossapp.dto.DonerDTO;
import com.xworkz.redcrossapp.dto.SearchDTO;

import java.util.Optional;

public interface DonerAccountRepository {

    boolean save(DonerDTO donerDTO);
    Optional<DonerDTO> findByEmail(SearchDTO searchDTO);
    Optional<DonerDTO> update(DonerDTO donerDTO);
    boolean deleteByEmail(String email);
}
