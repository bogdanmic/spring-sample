package com.gd.controllers;

import com.gd.models.entities.Phone;
import com.gd.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HibernateController {
    private final PhoneService phoneService;

    @Autowired
    public HibernateController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }
    @RequestMapping(value = "/phones/populate", method = RequestMethod.GET)
    public Boolean save() {
        Phone phone;
        phone = new Phone();
        phone.setName("Name 1");
        phone.setReview("Review 1");
        phoneService.addPhone(phone);

        phone = new Phone();
        phone.setName("Name 2");
        phone.setReview("Review 3");
        phoneService.addPhone(phone);

        phone = new Phone();
        phone.setName("Name 4");
        phone.setReview("Review 4");
        phoneService.addPhone(phone);

        phone = new Phone();
        phone.setName("Name 5");
        phone.setReview("Review 5");
        phoneService.addPhone(phone);
        return true;
    }
    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public List<Phone> listPhones() {
        return phoneService.listPhones();
    }

    // For add and update phone both
    @RequestMapping(value = "/phone/add", method = RequestMethod.POST)
    public String addPhone(@ModelAttribute("phone") Phone p) {

        if (p.getId() == 0) {
            // new phone, add it
            this.phoneService.addPhone(p);
        } else {
            // existing phone, call update
            this.phoneService.updatePhone(p);
        }

        return "redirect:/phones";

    }

    @RequestMapping("/remove/{id}")
    public String removePhone(@PathVariable("id") int id) {
        phoneService.removePhone(id);
        return "Done";
    }

    @RequestMapping("/phones/count")
    public Long countPhones() {
        return phoneService.countPhones();
    }

    @RequestMapping("/phones/sum")
    public Long sumPhones() {
        return phoneService.sumIds();
    }
}
