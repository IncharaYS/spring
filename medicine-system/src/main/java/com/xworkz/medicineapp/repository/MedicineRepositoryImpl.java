package com.xworkz.medicineapp.repository;


import com.xworkz.medicineapp.constants.DbConstants;
import com.xworkz.medicineapp.dto.MedicineDTO;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

@Component
public class MedicineRepositoryImpl implements MedicineRepository{


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
    public boolean save(MedicineDTO medicineDTO) {

        boolean isSaved=true;

//        String insertQuery="insert into medicine(medicine_name,price,mg,combination,exp_date) values(?,?,?,?,?);";
//        try(Connection connection= DriverManager.getConnection(DbConstants.URL.getProperties(),DbConstants.USERNAME.getProperties(), DbConstants.PASSWORD.getProperties());
//            PreparedStatement insertStatement=connection.prepareStatement(insertQuery)) {
//
//            insertStatement.setString(1, medicineDTO.getMedicineName());
//            insertStatement.setString(2, medicineDTO.getPrice());
//            insertStatement.setString(3, medicineDTO.getMg());
//            insertStatement.setString(4, medicineDTO.getCombination());
//            insertStatement.setString(5, medicineDTO.getExpDate());
//
//
//            int  rows=insertStatement.executeUpdate();
//            System.out.println("No of rows inserted:"+rows);
//
//
//            if(rows>0) isSaved=true;
//
//        }


        Configuration configuration=new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(MedicineDTO.class);

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        session.save(medicineDTO);

        transaction.commit();

        return isSaved;

    }

    @Override
    @SneakyThrows
    public Optional<MedicineDTO> searchByName(String medicineName) {
        String searchQuery="Select * from medicine where medicine_name=?;";

        try(Connection connection=DriverManager.getConnection(DbConstants.URL.getProperties(),DbConstants.USERNAME.getProperties(), DbConstants.PASSWORD.getProperties());
        PreparedStatement preparedStatement=connection.prepareStatement(searchQuery)){

            preparedStatement.setString(1,medicineName);
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id =  resultSet.getInt(1);
                String name =  resultSet.getString(2);
                String price =  resultSet.getString(3);
                String mg = resultSet.getString(4);
                String combination = resultSet.getString(5);
                String expDate = resultSet.getString(6);
                MedicineDTO medicineDTO = new MedicineDTO(id,name,price,mg,combination,expDate);
                return Optional.of(medicineDTO);
            }
        }

        return Optional.empty();


    }

    @Override
    public Optional<MedicineDTO> searchById(int id){
        Configuration configuration=new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(MedicineDTO.class);

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        MedicineDTO medicineDTO=session.get(MedicineDTO.class,id );

        transaction.commit();

        return Optional.ofNullable(medicineDTO);
    }
}
