package com.xworkz.jobportalapp.repository;


import com.xworkz.jobportalapp.constants.DbConstants;
import com.xworkz.jobportalapp.dto.JobSeekerDTO;
import com.xworkz.jobportalapp.dto.SearchDTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

@Repository
public class JobPortalRepositoryImpl implements JobPortalRepository {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not loaded");
        }
    }

    @Override
    @SneakyThrows
    public boolean save(JobSeekerDTO dto) {

        String sql = "INSERT INTO job_seeker_account " +
                "(email, first_name, last_name, phone, location, professional_summary, skills, " +
                "experienced, company_name, job_title, from_date, last_working_date, username, password) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(
                DbConstants.URL.getProperties(),
                DbConstants.USERNAME.getProperties(),
                DbConstants.PASSWORD.getProperties());
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dto.getEmail());
            ps.setString(2, dto.getFirstName());
            ps.setString(3, dto.getLastName());
            ps.setString(4, dto.getPhone());
            ps.setString(5, dto.getLocation());
            ps.setString(6, dto.getProfessionalSummary());
            ps.setString(7, dto.getSkills());
            ps.setBoolean(8, dto.isExperienced());
            ps.setString(9, dto.getCompanyName());
            ps.setString(10, dto.getJobTitle());
            ps.setDate(11, dto.getFromDate() != null ? Date.valueOf(dto.getFromDate()) : null);
            ps.setDate(12, dto.getLastWorkingDate() != null ? Date.valueOf(dto.getLastWorkingDate()) : null);
            ps.setString(13, dto.getUsername());
            ps.setString(14, dto.getPassword());

            int rows = ps.executeUpdate();
            System.out.println("Rows inserted: " + rows);
            return rows > 0;
        }
    }

    @Override
    @SneakyThrows
    public Optional<JobSeekerDTO> findByEmail(SearchDTO searchDTO) {

        String sql = "SELECT * FROM job_seeker_account WHERE email=?";

        try (Connection con = DriverManager.getConnection(
                DbConstants.URL.getProperties(),
                DbConstants.USERNAME.getProperties(),
                DbConstants.PASSWORD.getProperties());
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, searchDTO.getEmail());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JobSeekerDTO dto = new JobSeekerDTO();
                dto.setJobSeekerId(rs.getInt("job_seeker_id"));
                dto.setEmail(rs.getString("email"));
                dto.setFirstName(rs.getString("first_name"));
                dto.setLastName(rs.getString("last_name"));
                dto.setPhone(rs.getString("phone"));
                dto.setLocation(rs.getString("location"));
                dto.setProfessionalSummary(rs.getString("professional_summary"));
                dto.setSkills(rs.getString("skills"));
                dto.setExperienced(rs.getBoolean("experienced"));
                dto.setCompanyName(rs.getString("company_name"));
                dto.setJobTitle(rs.getString("job_title"));
                dto.setFromDate(rs.getDate("from_date") != null ?
                        rs.getDate("from_date").toString() : null);
                dto.setLastWorkingDate(rs.getDate("last_working_date") != null ?
                        rs.getDate("last_working_date").toString() : null);
                dto.setUsername(rs.getString("username"));
                dto.setPassword(rs.getString("password"));

                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public Optional<JobSeekerDTO> update(JobSeekerDTO dto) {

        String sql = "UPDATE job_seeker_account SET " +
                "first_name=?, last_name=?, phone=?, location=?, professional_summary=?, skills=?, " +
                "experienced=?, company_name=?, job_title=?, from_date=?, last_working_date=?, " +
                "username=?, password=? WHERE email=?";

        try (Connection con = DriverManager.getConnection(
                DbConstants.URL.getProperties(),
                DbConstants.USERNAME.getProperties(),
                DbConstants.PASSWORD.getProperties());
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dto.getFirstName());
            ps.setString(2, dto.getLastName());
            ps.setString(3, dto.getPhone());
            ps.setString(4, dto.getLocation());
            ps.setString(5, dto.getProfessionalSummary());
            ps.setString(6, dto.getSkills());
            ps.setBoolean(7, dto.isExperienced());
            ps.setString(8, dto.getCompanyName());
            ps.setString(9, dto.getJobTitle());
            ps.setDate(10, dto.getFromDate() != null ? Date.valueOf(dto.getFromDate()) : null);
            ps.setDate(11, dto.getLastWorkingDate() != null ? Date.valueOf(dto.getLastWorkingDate()) : null);
            ps.setString(12, dto.getUsername());
            ps.setString(13, dto.getPassword());
            ps.setString(14, dto.getEmail());

            int rows = ps.executeUpdate();
            System.out.println("Rows updated: " + rows);

            if (rows > 0) {
                SearchDTO searchDTO = new SearchDTO();
                searchDTO.setEmail(dto.getEmail());
                return findByEmail(searchDTO);
            }
        }
        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public boolean deleteByEmail(String email) {

        String sql = "DELETE FROM job_seeker_account WHERE email=?";

        try (Connection con = DriverManager.getConnection(
                DbConstants.URL.getProperties(),
                DbConstants.USERNAME.getProperties(),
                DbConstants.PASSWORD.getProperties());
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            int rows = ps.executeUpdate();
            System.out.println("Rows deleted: " + rows);
            return rows > 0;
        }
    }
}
