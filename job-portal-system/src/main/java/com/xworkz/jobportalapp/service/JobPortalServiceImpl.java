package com.xworkz.jobportalapp.service;


import com.xworkz.jobportalapp.dto.JobSeekerDTO;
import com.xworkz.jobportalapp.dto.SearchDTO;
import com.xworkz.jobportalapp.repository.JobPortalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobPortalServiceImpl implements JobPortalService {

    @Autowired
    private JobPortalRepository repository;

    @Override
    public boolean validateAndSave(JobSeekerDTO dto) {

        if (!validate(dto)) {
            System.err.println("Validation failed");
            return false;
        }
        return repository.save(dto);
    }

    private boolean validate(JobSeekerDTO dto) {

        if (dto == null) return false;

        if (dto.getEmail() == null || !dto.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.err.println("Invalid email");
            return false;
        }

        if (dto.getFirstName() == null || dto.getFirstName().length() < 2) {
            System.err.println("Invalid first name");
            return false;
        }

        if (dto.getLastName() == null || dto.getLastName().length() < 2) {
            System.err.println("Invalid last name");
            return false;
        }

        if (dto.getPhone() == null || !dto.getPhone().matches("\\d{10}")) {
            System.err.println("Invalid phone");
            return false;
        }

        if (dto.getUsername() == null || dto.getUsername().length() < 5) {
            System.err.println("Invalid username");
            return false;
        }

        if (dto.getPassword() == null || dto.getPassword().length() < 8) {
            System.err.println("Invalid password");
            return false;
        }

        if (dto.isExperienced()) {
            if (dto.getCompanyName() == null || dto.getJobTitle() == null) {
                System.err.println("Experience details missing");
                return false;
            }
        }

        System.out.println("All job seeker data is valid");
        return true;
    }

    @Override
    public Optional<JobSeekerDTO> validateAndSearch(SearchDTO searchDTO) {

        if (searchDTO.getEmail() == null || searchDTO.getEmail().length() < 6) {
            System.err.println("Invalid email for search");
            return Optional.empty();
        }
        return repository.findByEmail(searchDTO);
    }

    @Override
    public JobSeekerDTO update(JobSeekerDTO dto) {

        if (!validate(dto)) {
            System.err.println("Update validation failed");
            return null;
        }

        Optional<JobSeekerDTO> updated = repository.update(dto);
        return updated.orElse(null);
    }

    @Override
    public boolean deleteByEmail(String email) {

        if (email == null || email.length() < 6) {
            System.err.println("Invalid email for delete");
            return false;
        }
        return repository.deleteByEmail(email);
    }
}
