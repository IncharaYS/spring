package com.xworkz.jobportalapp.repository;


import com.xworkz.jobportalapp.dto.JobSeekerDTO;
import com.xworkz.jobportalapp.dto.SearchDTO;

import java.util.Optional;

public interface JobPortalRepository {

    boolean save(JobSeekerDTO dto);

    Optional<JobSeekerDTO> findByEmail(SearchDTO searchDTO);

    Optional<JobSeekerDTO> update(JobSeekerDTO dto);

    boolean deleteByEmail(String email);
}
