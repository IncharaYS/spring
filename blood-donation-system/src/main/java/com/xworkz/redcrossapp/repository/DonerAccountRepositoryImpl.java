package com.xworkz.redcrossapp.repository;

import com.xworkz.redcrossapp.constants.DbConstants;
import com.xworkz.redcrossapp.dto.DonerDTO;
import com.xworkz.redcrossapp.dto.SearchDTO;
import com.xworkz.redcrossapp.entity.DonerEntity;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.*;
import java.util.Optional;


@Repository
public class DonerAccountRepositoryImpl implements DonerAccountRepository{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

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
    public boolean save(DonerEntity donerEntity) {

        System.out.println(donerEntity);

        boolean isSaved = true;
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(donerEntity);
        entityManager.getTransaction().commit();

        entityManager.close();
        return isSaved;
    }


    @Override
    @SneakyThrows
    public Optional<DonerEntity> findByEmail(String email) {



            EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("findByEmail");
            DonerEntity donerEntity = (DonerEntity) query.setParameter("email", email).getSingleResult();
            entityManager.getTransaction().commit();

            entityManager.close();


            System.out.println(donerEntity);
            return Optional.of(donerEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }


    @Override
    public boolean update(DonerEntity donerEntity) {

        boolean isUpdated=false;


        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("update");
            int rowsUpdated = query.setParameter("donerId", donerEntity.getDonorId()).setParameter("firstName", donerEntity.getDonerFirstName()).setParameter("lastName", donerEntity.getDonerLastName()).setParameter("zipCode", donerEntity.getDonerZipCode()).setParameter("userName", donerEntity.getDonerUsername()).setParameter("password", donerEntity.getDonerPassword()).setParameter("id", donerEntity.getId()).executeUpdate();
            entityManager.getTransaction().commit();

            entityManager.close();

            if (rowsUpdated > 0) {
                isUpdated = true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isUpdated;
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

    @Override
    public boolean deleteById(int id){

        boolean isDeleted=false;

        try {
            EntityManager em = entityManagerFactory.createEntityManager();

            Query query = em.createNamedQuery("deleteById");
            em.getTransaction().begin();
            int rowsDeleted = query.setParameter("eId", id).executeUpdate();

            em.getTransaction().commit();
            em.close();

            if (rowsDeleted > 0) {
                System.out.println("Successfully deleted doner with id:" + id);
                isDeleted = true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isDeleted;

    }

}
