package com.gd.repositories;

import com.gd.models.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    // !!!THESE 2 methods bellow are autogenerated by spring.!!!
    // Enabling ignoring case for an individual property
    List<Customer> findByFirstNameIgnoreCase(String firstName);

    // Enabling static ORDER BY for a query
    List<Customer> findByLastNameOrderByFirstNameAsc(String lastName);

    @Query("select u.id, LENGTH(u.firstName) as fn_len,u.firstName, u.lastName from Customer u where u.lastName like %?1%")
    List<Object[]> findByAsArrayAndSort(String lastName, Sort sort);
}
