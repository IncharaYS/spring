package com.xworkz.Iapp.repository;

import com.xworkz.Iapp.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(MemberEntity entity) {

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(entity);

            em.getTransaction().commit();
            em.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            return false;

        }
    }

    @Override
    public List<MemberEntity> findByTeamId(int teamId) {

        EntityManager em = entityManagerFactory.createEntityManager();

            try {

                List<MemberEntity> members =(List<MemberEntity>) em.createNamedQuery("findByTeamId").setParameter("teamId", teamId).getResultList();

                em.close();
                return members;

            } catch (Exception e) {
                e.printStackTrace();
                em.close();
                return Collections.emptyList();
            }
        }


    @Override
    public Optional<MemberEntity> findById(int memberId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            MemberEntity entity = em.find(MemberEntity.class, memberId);
            em.close();
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            em.close();
            return Optional.empty();
        }
    }

    @Override
    public boolean update(MemberEntity entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            return false;
        }
    }

    @Override
    public boolean delete(int memberId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            MemberEntity entity = em.find(MemberEntity.class, memberId);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            return false;
        }
    }
}



