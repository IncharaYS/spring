package com.xworkz.matrimonyApp.repository;

import com.xworkz.matrimonyApp.constants.DbConstants;
import com.xworkz.matrimonyApp.dto.MatrimonyDTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class MatrimonyRepositoryImpl implements MatrimonyRepository{

    static{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @SneakyThrows
    public boolean save(MatrimonyDTO matrimonyDTO) {

        boolean isSaved = false;
        String insertQuery = "insert into matrimony(email,create_profile_for,gender,date_of_birth,mother_tongue,religion,marital_status,height) values(?,?,?,?,?,?,?,?);";

        try (Connection connection = DriverManager.getConnection(DbConstants.URL.getProperties(), DbConstants.USERNAME.getProperties(), DbConstants.PASSWORD.getProperties());
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){

                preparedStatement.setString(1, matrimonyDTO.getEmail());
                preparedStatement.setString(2, matrimonyDTO.getCreateProfileFor());
                preparedStatement.setString(3, matrimonyDTO.getGender());
                preparedStatement.setString(4, matrimonyDTO.getDateOfBirth());
                preparedStatement.setString(5, matrimonyDTO.getMotherTongue());
                preparedStatement.setString(6, matrimonyDTO.getReligion());
                preparedStatement.setString(7, matrimonyDTO.getMaritalStatus());
                preparedStatement.setDouble(8, matrimonyDTO.getHeight());

                int rows=preparedStatement.executeUpdate();
                System.out.println("Successfully inserted no of rows:" +rows);

                if(rows>0) {
                    isSaved = true;
            }
        }

        return  isSaved;

    }
}
