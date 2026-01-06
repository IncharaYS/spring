package com.xworkz.jobportalapp.service;

import com.xworkz.jobportalapp.dto.JobSeekerDTO;
import com.xworkz.jobportalapp.dto.SearchDTO;

import java.util.Optional;

public interface JobPortalService {

    boolean validateAndSave(JobSeekerDTO dto);

    Optional<JobSeekerDTO> validateAndSearch(SearchDTO dto);

    JobSeekerDTO update(JobSeekerDTO dto);

    boolean deleteByEmail(String email);
}
