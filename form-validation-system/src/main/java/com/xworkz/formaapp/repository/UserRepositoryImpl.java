package com.xworkz.formaapp.repository;


import com.xworkz.formaapp.entity.UserEntity;
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
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            em.persist(userEntity);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Query query = em.createNamedQuery("findByEmail");
            query.setParameter("email", email);
            return Optional.of((UserEntity) query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserEntity> findByPhoneNo(String phoneNo) {
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Query query = em.createNamedQuery("findByPhoneNo");
            query.setParameter("phoneNo", phoneNo);
            return Optional.of((UserEntity) query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

