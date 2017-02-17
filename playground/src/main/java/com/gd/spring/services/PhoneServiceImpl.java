package com.gd.spring.services;


import com.gd.spring.events.MyCustomEvent;
import com.gd.spring.models.dao.PhoneDAO;
import com.gd.spring.models.entities.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PhoneServiceImpl implements PhoneService, ApplicationEventPublisherAware {

    private PhoneDAO phoneDAO;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public void setPhoneDAO(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @Override
    @Transactional
    public void addPhone(Phone p) {
        this.phoneDAO.addPhone(p);
    }

    @Override
    @Transactional
    public void updatePhone(Phone p) {
        this.phoneDAO.updatePhone(p);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    @Override
    @Transactional
    public List<Phone> listPhones() {
        eventPublisher.publishEvent(new MyCustomEvent(this));
        return this.phoneDAO.listPhones();
    }

    @Override
    @Transactional
    public Phone getPhoneById(int id) {
        return this.phoneDAO.getPhoneById(id);
    }

    @Override
    @Transactional
    public void removePhone(int id) {
        this.phoneDAO.removePhone(id);
    }

    @Override
    public Long countPhones() {
        return phoneDAO.countPhones();
    }

    @Override
    public Long sumIds() {
        return phoneDAO.sumIds();
    }
}
