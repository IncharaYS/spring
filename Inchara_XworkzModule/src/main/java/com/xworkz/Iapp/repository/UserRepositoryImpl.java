package com.xworkz.Iapp.repository;

import com.xworkz.Iapp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public boolean save(UserEntity userEntity) {

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(userEntity);

            entityManager.getTransaction().commit();
            entityManager.close();

            return true;

        }
        catch (Exception e) {
            return false;
        }
    }


    @Override
    public Optional<UserEntity> findByEmail(String email) {

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("email", email);

            UserEntity userEntity = (UserEntity) query.getSingleResult();

            return Optional.of(userEntity);
        }

        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserEntity> findByPhoneNo(String phoneNo) {

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createNamedQuery("findByPhoneNo");
            query.setParameter("phoneNo", phoneNo);

            UserEntity userEntity = (UserEntity) query.getSingleResult();

            return Optional.of(userEntity);
        }

        catch (Exception e) {
            return Optional.empty();
        }
    }


    @Override
    public void incrementCount(String email) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createNamedQuery("incrementCount");
            query.setParameter("email", email);
            int rowsUpdated= query.executeUpdate();

            entityManager.getTransaction().commit();

            if(rowsUpdated>0){
                System.out.println("Increment successful");
            }
            else System.out.println("Increment failed");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

