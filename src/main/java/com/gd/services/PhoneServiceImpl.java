package com.gd.services;


import java.util.List;

import com.gd.models.dao.PhoneDAO;
import com.gd.models.entities.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PhoneServiceImpl implements PhoneService {

    private PhoneDAO phoneDAO;

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
    @Transactional
    public List<Phone> listPhones() {
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
