package com.xworkz.medicalStoreApp.repository;

import com.xworkz.medicalStoreApp.constants.DbConstants;
import com.xworkz.medicalStoreApp.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class MedicalStoreRepositoryImpl implements MedicalStoreRepository{

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch ( ClassNotFoundException cnfe){
            System.out.println("Driver not loaded");
            cnfe.printStackTrace();
        }
    }

    @Override
    public boolean save(CustomerDTO customerDTO) {
        boolean isSaved=false;

        String insertQuery = "insert into customer_info(full_name,email,password,phone_no,age) values(?,?,?,?,?);";
        try (Connection connection = DriverManager.getConnection(DbConstants.URL.getProperties(),DbConstants.USERNAME.getProperties(),DbConstants.PASSWORD.getProperties());
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){


            preparedStatement.setString(1, customerDTO.getFullName());
            preparedStatement.setString(2, customerDTO.getEmail());
            preparedStatement.setString(3, customerDTO.getPassword());
            preparedStatement.setLong(4, customerDTO.getPhoneNo());
            preparedStatement.setInt(5, customerDTO.getAge());


            int rows = preparedStatement.executeUpdate();
            System.out.println("Successfully inserted rows:" + rows);

            isSaved = true;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return isSaved;
        }

        return  isSaved;
    }
}
