package com.xworkz.eventapp.repository;


import com.xworkz.eventapp.entity.EventEntity;
import lombok.SneakyThrows;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class EventRepositoryImpl implements EventRepository{
    @Override
    public boolean save(EventEntity eventEntity) {

        boolean isSaved=false;

        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.event.xml");
            configuration.addAnnotatedClass(EventEntity.class);

            try(SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.openSession();) {


                Transaction transaction = session.beginTransaction();

                session.save(eventEntity);

                transaction.commit();
                isSaved = true;
            }
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
        boolean isFetched=false;

        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.event.xml");
            configuration.addAnnotatedClass(EventEntity.class);

            try(SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.openSession();) {

                EventEntity eventEntity=session.get(EventEntity.class,id);
                if(eventEntity!=null){
                    isFetched=true;
                }


                if(isFetched){
                    System.out.println(eventEntity);
                    return Optional.of(eventEntity);
                }
            }

        }

        catch (HibernateException he){
            System.out.println("Hibernate Exception");
            he.printStackTrace();
        }
        return Optional.empty();
    }
}
