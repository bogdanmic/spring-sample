package com.gd.models.dao;

import com.gd.models.entities.Phone;

import java.util.List;

public interface PhoneDAO {

    public void addPhone(Phone p);
    public void updatePhone(Phone p);
    public List<Phone> listPhones();
    public Phone getPhoneById(int id);
    public void removePhone(int id);

    Long countPhones();

    Long sumIds();
}
