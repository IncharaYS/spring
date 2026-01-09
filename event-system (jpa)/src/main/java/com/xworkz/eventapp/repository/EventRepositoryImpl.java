package com.xworkz.eventapp.repository;


import com.xworkz.eventapp.entity.EventEntity;
import com.xworkz.eventapp.util.EntityManagerFactoryUtil;
import lombok.SneakyThrows;
import org.hibernate.HibernateException;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EventRepositoryImpl implements EventRepository{

    EntityManagerFactory entityManagerFactory= EntityManagerFactoryUtil.getEntityManagerFactory();

    @Override
    public boolean save(EventEntity eventEntity) {

        boolean isSaved=false;

        try {

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            entityManager.persist(eventEntity);
            entityManager.getTransaction().commit();


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

            EntityManager entityManager = entityManagerFactory.createEntityManager();


                Query query=entityManager.createNamedQuery("getById");
                EventEntity eventEntity=(EventEntity) query.setParameter("eId",id).getSingleResult();
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
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            Query query=entityManager.createNamedQuery("deleteById");
            int rowsDeleted=query.setParameter("eId",id).executeUpdate();

            if (rowsDeleted>0){
                isDeleted=true;
            }


            entityManager.getTransaction().commit();
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
                EntityManager entityManager = entityManagerFactory.createEntityManager();


            entityManager.getTransaction().begin();
            Query query=entityManager.createNamedQuery("updateEventTimeById");
            int rowsUpdated=query.setParameter("eId",id).setParameter("eTime",time).executeUpdate();
            if (rowsUpdated>0){
                isUpdated = true;
                System.out.println("Updated successfully");
            }


            else {
                System.err.println("Failed to update");
            }

            entityManager.getTransaction().commit();


            entityManager.close();
        }

            catch (HibernateException he){
            System.out.println("Hibernate Exception");
            he.printStackTrace();
        }


        return isUpdated;
    }


    @Override
    @SneakyThrows
    public Optional<EventEntity> getEventByEventName(String eventName) {

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query=entityManager.createNamedQuery("getEventByEventName");
            query.setParameter("eName",eventName);
            EventEntity eventEntity=(EventEntity)query.getSingleResult();

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
        catch (NoResultException nre){
            System.out.println("No result to fetch");
            nre.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean updateEventTimeByName(String eventName,String time) {

        boolean isUpdated=false;

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();


            entityManager.getTransaction().begin();

            Query query=entityManager.createNamedQuery("updateEventTimeByName");
            query.setParameter("eName",eventName);
            EventEntity eventEntity=(EventEntity) query.getSingleResult();

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

            entityManager.close();
        }

        catch (HibernateException he){
            System.out.println("Hibernate Exception");
            he.printStackTrace();
        }


        return isUpdated;
    }

    @Override
    public List<EventEntity> getEvents() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Query query=entityManager.createNamedQuery("getEvents");
            List<EventEntity> eventEntity=(List<EventEntity>) query.getResultList();

            entityManager.close();

            if(eventEntity!=null){
                System.out.println(eventEntity);
                return eventEntity;
            }
        }

        catch (HibernateException he){
            System.out.println("Hibernate Exception");
            he.printStackTrace();
        }
        catch (NoResultException nre){
            System.out.println("No result to fetch");
            nre.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<EventEntity> getEventByEventLocation(String eventLocation) {

        List<EventEntity> events = new ArrayList<>();

        try {
            EntityManager em = entityManagerFactory.createEntityManager();

            Query query = em.createNamedQuery("getEventByEventLocation");
            query.setParameter("eLocation", eventLocation);
            events = query.getResultList();
            em.close();


        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return events;
    }


    @Override
    public List<EventEntity> getEventByEventManager(String eventManager) {

        List<EventEntity> events = new ArrayList<>();

        try {
            EntityManager em = entityManagerFactory.createEntityManager();

            Query query = em.createNamedQuery("getEventByEventManager");
            query.setParameter("eManager", eventManager);
            events = query.getResultList();

            em.close();

        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return events;
    }


    @Override
    public List<EventEntity> getEventByEventTime(String eventTime) {

        List<EventEntity> events = new ArrayList<>();

        try {
            EntityManager em = entityManagerFactory.createEntityManager();

            Query query = em.createNamedQuery("getEventByEventTime");
            query.setParameter("eTime", eventTime);

            events = query.getResultList();

            em.close();

        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return events;
    }

    @Override
    public Object[] getManagerAndLocationByEventName(String eventName) {

        Object[] result = null;

        try {
            EntityManager em = entityManagerFactory.createEntityManager();

            Query query = em.createNamedQuery("getManagerAndLocationByEventName");
            query.setParameter("eName", eventName);

            result = (Object[]) query.getSingleResult();

            em.close();

        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return result;
    }

    @Override
    public List<String> getLocationByTime(String time) {
        List<String>  locations= new ArrayList<>();

        try {
            EntityManager em = entityManagerFactory.createEntityManager();

            Query query = em.createNamedQuery("getLocationByTime");
            query.setParameter("eTime", time);

            locations = query.getResultList();

            em.close();

        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return locations;
    }

    @Override
    public String getNameByManager(String manager) {
        String eventName=null;
        try {
            EntityManager em = entityManagerFactory.createEntityManager();

            Query query = em.createNamedQuery("getNameByManager");
            query.setParameter("eManager", manager);

            eventName =(String) query.getSingleResult();

            em.close();

        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return eventName;
    }

    @Override
    public List<String> getMangers() {
        List<String>  managers= new ArrayList<>();

        try {
            EntityManager em = entityManagerFactory.createEntityManager();

            Query query = em.createNamedQuery("getMangers");

            managers = query.getResultList();

            em.close();

        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return managers;
    }


}
