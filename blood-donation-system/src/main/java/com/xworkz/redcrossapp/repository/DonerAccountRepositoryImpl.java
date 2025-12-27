package com.xworkz.redcrossapp.repository;

import com.mysql.cj.jdbc.Driver;
import com.xworkz.redcrossapp.constants.DbConstants;
import com.xworkz.redcrossapp.dto.DonerDTO;
import com.xworkz.redcrossapp.dto.SearchDTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Optional;

@Component
@Repository
public class DonerAccountRepositoryImpl implements DonerAccountRepository{


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException enfe){
            System.out.println("Driver not loaded");
        }
    }
    @Override
    @SneakyThrows
    public boolean save(DonerDTO donerDTO) {

        boolean isSaved = false;

        String insertQuery =
                "INSERT INTO doner_account " +
                        "(doner_email, doner_birth_year, doner_birth_month, doner_birth_day, " +
                        "donor_id, doner_first_name, doner_last_name, doner_zip_code, " +
                        "doner_username, doner_password) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL.getProperties(),
                DbConstants.USERNAME.getProperties(),
                DbConstants.PASSWORD.getProperties());
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, donerDTO.getDonerEmail());
            preparedStatement.setInt(2, donerDTO.getDonerBirthYear());
            preparedStatement.setString(3, donerDTO.getDonerBirthMonth());
            preparedStatement.setInt(4, donerDTO.getDonerBirthDay());
            preparedStatement.setString(5, donerDTO.getDonorId());
            preparedStatement.setString(6, donerDTO.getDonerFirstName());
            preparedStatement.setString(7, donerDTO.getDonerLastName());
            preparedStatement.setString(8, donerDTO.getDonerZipCode());
            preparedStatement.setString(9, donerDTO.getDonerUsername());
            preparedStatement.setString(10, donerDTO.getDonerPassword());

            int rows = preparedStatement.executeUpdate();
            System.out.println("Doner account inserted successfully. Rows affected: " + rows);

            isSaved = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSaved;
    }


    @Override
    @SneakyThrows
    public Optional<DonerDTO> findByEmail(SearchDTO searchDTO) {

        String query = "SELECT * FROM doner_account WHERE doner_email=?";

        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL.getProperties(),
                DbConstants.USERNAME.getProperties(),
                DbConstants.PASSWORD.getProperties());
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, searchDTO.getEmail());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    DonerDTO donerDTO = new DonerDTO();
                    donerDTO.setDonerEmail(rs.getString("doner_email"));
                    donerDTO.setDonerBirthYear(rs.getInt("doner_birth_year"));
                    donerDTO.setDonerBirthMonth(rs.getString("doner_birth_month"));
                    donerDTO.setDonerBirthDay(rs.getInt("doner_birth_day"));
                    donerDTO.setDonorId(rs.getString("donor_id"));
                    donerDTO.setDonerFirstName(rs.getString("doner_first_name"));
                    donerDTO.setDonerLastName(rs.getString("doner_last_name"));
                    donerDTO.setDonerZipCode(rs.getString("doner_zip_code"));
                    donerDTO.setDonerUsername(rs.getString("doner_username"));
                    donerDTO.setDonerPassword(rs.getString("doner_password"));
                    return Optional.of(donerDTO);
                }
            }
        }

        return Optional.empty();
    }


    @SneakyThrows
    @Override
    public Optional<DonerDTO> update(DonerDTO donerDTO) {

        String updateQuery =
                "UPDATE doner_account SET " +
                        "doner_first_name=?, " +
                        "doner_last_name=?, " +
                        "doner_username=?, " +
                        "doner_zip_code=?, " +
                        "doner_password=?, " +
                        "donor_id=? " +
                        "WHERE doner_email=?";

        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL.getProperties(),
                DbConstants.USERNAME.getProperties(),
                DbConstants.PASSWORD.getProperties());
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setString(1, donerDTO.getDonerFirstName());
            ps.setString(2, donerDTO.getDonerLastName());
            ps.setString(3, donerDTO.getDonerUsername());
            ps.setString(4, donerDTO.getDonerZipCode());
            ps.setString(5, donerDTO.getDonerPassword());
            ps.setString(6, donerDTO.getDonorId());
            ps.setString(7, donerDTO.getDonerEmail());

            int rows = ps.executeUpdate();
            System.out.println("Rows updated: " + rows);

            if (rows > 0) {
                SearchDTO searchDTO = new SearchDTO();
                searchDTO.setEmail(donerDTO.getDonerEmail());
                return findByEmail(searchDTO);
            }
        }

        return Optional.empty();
    }


    @Override
    @SneakyThrows
    public boolean deleteByEmail(String email) {

        String deleteQuery =
                "DELETE FROM doner_account WHERE doner_email = ?";

        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL.getProperties(),
                DbConstants.USERNAME.getProperties(),
                DbConstants.PASSWORD.getProperties());

             PreparedStatement preparedStatement =
                     connection.prepareStatement(deleteQuery)) {

            preparedStatement.setString(1, email);

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows deleted: " + rows);

            return rows > 0;
        }
    }

}
