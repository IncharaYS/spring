package com.xworkz.Iapp.repository;

import com.xworkz.Iapp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public boolean save(UserEntity userEntity) {

        boolean isSaved = false;

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(userEntity);

            entityManager.getTransaction().commit();
            entityManager.close();

            isSaved = true;

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return isSaved;
    }


    @Override
    public Optional<UserEntity> findByEmail(String email) {

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("email", email);

            UserEntity userEntity = (UserEntity) query.getSingleResult();

            if (userEntity != null) {
                return Optional.of(userEntity);
            }

        } catch (NoResultException nre) {
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
