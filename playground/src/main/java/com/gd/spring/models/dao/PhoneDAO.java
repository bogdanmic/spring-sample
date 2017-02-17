package com.gd.spring.models.dao;


import com.gd.spring.models.entities.Phone;

import java.util.List;

public interface PhoneDAO {

    void addPhone(Phone p);
    void updatePhone(Phone p);
    List<Phone> listPhones();
    Phone getPhoneById(int id);
    void removePhone(int id);

    Long countPhones();

    Long sumIds();
}
