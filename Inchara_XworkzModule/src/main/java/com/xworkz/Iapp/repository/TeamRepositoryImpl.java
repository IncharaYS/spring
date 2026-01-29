package com.xworkz.Iapp.repository;

import com.xworkz.Iapp.entity.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepositoryImpl implements TeamRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(TeamEntity teamEntity) {

        try {
            EntityManager em = entityManagerFactory.createEntityManager();

            em.getTransaction().begin();
            em.persist(teamEntity);

            em.getTransaction().commit();

            em.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




    @Override
    public Optional<TeamEntity> findByEmail(String email) {
        try {

            EntityManager em = entityManagerFactory.createEntityManager();

            Query query = em.createNamedQuery("findTeamByEmail");
            TeamEntity entity =(TeamEntity) query.setParameter("email", email).getSingleResult();

            em.close();
            return Optional.of(entity);


        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }



    @Override
    public List<TeamEntity> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            Query query = em.createNamedQuery("findAllTeams");
            List<TeamEntity> list = (List<TeamEntity>) query.getResultList();

            em.close();
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<TeamEntity> findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {

            TeamEntity entity = em.find(TeamEntity.class, id);
            em.close();
            return Optional.of(entity);
        }

        catch (Exception e){
            e.printStackTrace();
            em.close();
            return Optional.empty();
        }
    }

    @Override
    public boolean updateTeam(TeamEntity entity) {

        EntityManager em=entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(entity);

            em.getTransaction().commit();
            em.close();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            em.close();
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        EntityManager em=entityManagerFactory.createEntityManager();

        try {
            TeamEntity entity = em.find(TeamEntity.class, id);

            if (entity == null) {
                return false;
            }

            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            em.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            return false;
        }
    }
}

