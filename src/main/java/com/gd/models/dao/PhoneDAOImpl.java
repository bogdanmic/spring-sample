package com.gd.models.dao;

import com.gd.models.entities.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class PhoneDAOImpl implements PhoneDAO {

    private static final Logger logger = LoggerFactory.getLogger(PhoneDAOImpl.class);

    @PersistenceContext
    EntityManager em;

    @Override
    public void addPhone(Phone p) {
        em.persist(p);
        logger.info("Phone saved successfully, Phone Details=" + p);
    }

    @Override
    public void updatePhone(Phone p) {
        em.merge(p);
        logger.info("Phone updated successfully, Phone Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Phone> listPhones() {
        List<Phone> phonesList = em.createQuery("from Phone").getResultList();
        for (Phone p : phonesList) {
            logger.info("Phone List::" + p);
        }
        return phonesList;
    }

    @Override
    public Phone getPhoneById(int id) {

        Phone p = (Phone) em.find(Phone.class, new Integer(id));
        logger.info("Phone loaded successfully, Phone details=" + p);
        return p;
    }

    @Override
    public void removePhone(int id) {
        Phone p = (Phone) em.find(Phone.class, new Integer(id));
        if (null != p) {
            em.remove(p);
        }
        logger.info("Phone deleted successfully, phone details=" + p);
    }

    @Override
    public Long countPhones() {
        // Sample of count with criteria builder.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        Root<Phone> root = criteria.from(Phone.class);
        criteria.select(cb.count(root));
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public Long sumIds() {
        return em.createQuery("SELECT SUM(e.id) FROM Phone e", Long.class).getSingleResult();
    }
}
