package com.xworkz.eventapp.repository;


import com.xworkz.eventapp.entity.EventEntity;
import lombok.SneakyThrows;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class EventRepositoryImpl implements EventRepository{
    @Override
    public boolean save(EventEntity eventEntity) {

        boolean isSaved=false;

        try {
            EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("eventPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();


            entityManager.getTransaction().begin();
            entityManager.persist(eventEntity);
            entityManager.getTransaction().commit();

            entityManagerFactory.close();
            entityManager.close();

            isSaved = true;

        }

        catch (HibernateException he){
            System.out.println("Hibernate Exception");
            he.printStackTrace();
        }


        return isSaved;
    }

    @Override
    @SneakyThrows
    public Optional<EventEntity> getById(int id) {

        try {

            EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("eventPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();


                EventEntity eventEntity=entityManager.find(EventEntity.class,id);
                 entityManagerFactory.close();
                entityManager.close();

                if(eventEntity!=null){
                    System.out.println(eventEntity);
                    return Optional.of(eventEntity);
                }

        }

        catch (HibernateException he){
            System.out.println("Hibernate Exception");
            he.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(int id) {
    boolean   isDeleted=false;

        try {
            EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("eventPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            EventEntity eventEntity=entityManager.find(EventEntity.class,id);


            if(eventEntity!=null){
                entityManager.remove(eventEntity);
                isDeleted=true;
            }

            entityManager.getTransaction().commit();

            entityManagerFactory.close();
            entityManager.close();
        }

        catch (HibernateException he){
            System.out.println("Hibernate Exception");
            he.printStackTrace();
        }


    return  isDeleted;
    }



    @Override
    public boolean updateEventTimeById(int id,String time) {

        boolean isUpdated=false;

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("eventPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();


            entityManager.getTransaction().begin();

            EventEntity eventEntity = entityManager.find(EventEntity.class, id);
            if (eventEntity != null) {
                eventEntity.setEventTime(time);
                entityManager.merge(eventEntity);
                isUpdated = true;
                System.out.println("Updated successfully");
            }

            else {
                System.err.println("Failed to update");
            }

            entityManager.getTransaction().commit();

            entityManagerFactory.close();
            entityManager.close();
        }

            catch (HibernateException he){
            System.out.println("Hibernate Exception");
            he.printStackTrace();
        }


        return isUpdated;
    }
}
