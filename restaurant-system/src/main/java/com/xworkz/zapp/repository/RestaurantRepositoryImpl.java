package com.xworkz.zapp.repository;

import com.xworkz.zapp.dto.RestaurantDTO;
import com.xworkz.zapp.constants.DbConstants;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Optional;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not loaded");
        }
    }

    @Override
    public boolean save(RestaurantDTO restaurantDTO) {

        boolean isSaved = true;


//        String insertQuery =
//                "INSERT INTO restaurant " +
//                        "(name, owner, number, address, email, type, rating, established_year, opening_time, closing_time) " +
//                        "VALUES (?,?,?,?,?,?,?,?,?,?)";
//
//        try (Connection connection = DriverManager.getConnection(
//                DbConstants.URL.getProperties(),
//                DbConstants.USERNAME.getProperties(),
//                DbConstants.PASSWORD.getProperties());
//             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
//
//            preparedStatement.setString(1, restaurantDTO.getName());
//            preparedStatement.setString(2, restaurantDTO.getOwner());
//            preparedStatement.setLong(3, restaurantDTO.getContactNumber());
//            preparedStatement.setString(4, restaurantDTO.getAddress());
//            preparedStatement.setString(5, restaurantDTO.getContactEmail());
//            preparedStatement.setString(6, restaurantDTO.getType());
//            preparedStatement.setDouble(7, restaurantDTO.getRating());
//            preparedStatement.setString(8, restaurantDTO.getEstablishedYear());
//            preparedStatement.setString(9, restaurantDTO.getOpeningTime());
//            preparedStatement.setString(10, restaurantDTO.getClosingTime());
//
//            int rows = preparedStatement.executeUpdate();
//            System.out.println("Restaurant inserted successfully. Rows affected: " + rows);
//
//            isSaved = true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Configuration configuration=new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(RestaurantDTO.class);

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        session.save(restaurantDTO);
        transaction.commit();

        return isSaved;
    }


    @Override
    @SneakyThrows
    public Optional<RestaurantDTO> searchByName(String name) {
        String searchQuery = "select * from restaurant where name=?;";

        try(Connection connection = DriverManager.getConnection(DbConstants.URL.getProperties(), DbConstants.USERNAME.getProperties(), DbConstants.PASSWORD.getProperties());
            PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)){

            preparedStatement.setString(1,name);

            ResultSet set = preparedStatement.executeQuery();

            if (set.next()){
                int id =  set.getInt(1);
                String restaurantName =  set.getString(2);
                String owner =  set.getString(3);
                long contactNo =  set.getLong(4);
                String address =  set.getString(5);
                String email =   set.getString(6);
                String type =   set.getString(7);
                double rating =  set.getDouble(8);
                String establishedYear =  set.getString(9);
                String openingTime =  set.getString(10);
                String closingTime =  set.getString(11);

                RestaurantDTO restaurantDTO = new RestaurantDTO(id,restaurantName,owner,contactNo, address,email,type,rating,establishedYear,openingTime,closingTime);
                System.out.println(restaurantDTO);

                return Optional.of(restaurantDTO);
            }
        }

        return Optional.empty();
    }
}
