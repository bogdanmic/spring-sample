package com.gd.services;

import com.gd.models.entities.Phone;

import java.util.List;


public interface PhoneService {

    void addPhone(Phone p);
    void updatePhone(Phone p);
    List<Phone> listPhones();
    Phone getPhoneById(int id);
    void removePhone(int id);

    Long countPhones();

    Long sumIds();
}
