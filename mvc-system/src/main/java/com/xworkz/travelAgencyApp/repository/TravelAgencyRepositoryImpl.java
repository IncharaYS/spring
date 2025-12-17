package com.xworkz.travelAgencyApp.repository;

import com.xworkz.travelAgencyApp.constants.DbConstants;
import com.xworkz.travelAgencyApp.dto.UserDTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Component
public class TravelAgencyRepositoryImpl implements TravelAgencyRepository {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe ){
            System.out.println("Driver not loaded");
            cnfe.printStackTrace();
        }
    }

    @Override
    @SneakyThrows
    public boolean save(UserDTO userDTO) {

        boolean isSaved=false;
        String insertQuery="insert into user_info(full_name,email,password,phone_no,country,is_deleted)values(?,?,?,?,?,0);";
        try(Connection connection= DriverManager.getConnection(DbConstants.URL.getProperties(),DbConstants.USERNAME.getProperties(), DbConstants.PASSWORD.getProperties());
            PreparedStatement insertStatement=connection.prepareStatement(insertQuery)) {

            insertStatement.setString(1,userDTO.getFullName());
            insertStatement.setString(2,userDTO.getEmail());
            insertStatement.setString(3,userDTO.getPassword());
            insertStatement.setLong(4,userDTO.getPhoneNo());
            insertStatement.setString(5,userDTO.getCountry());

            int noOfRowsInserted= insertStatement.executeUpdate();
            System.out.println("No of rows inserted:"+noOfRowsInserted);

            if(noOfRowsInserted>0){
                isSaved=true;
            }
        }

        return isSaved;
    }
}
