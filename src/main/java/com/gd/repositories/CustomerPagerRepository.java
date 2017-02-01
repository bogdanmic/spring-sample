package com.gd.repositories;

import com.gd.models.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerPagerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Query("SELECT u.id FROM Customer u WHERE u.lastName LIKE %?1% OR u.firstName LIKE %?1%")
    Page<Long> customMethod(String like, Pageable page);


}
