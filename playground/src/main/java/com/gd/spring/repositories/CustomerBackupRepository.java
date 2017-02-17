package com.gd.spring.repositories;

import com.gd.spring.models.entities.CustomerBackup;
import org.springframework.data.repository.CrudRepository;

public interface CustomerBackupRepository extends CrudRepository<CustomerBackup, Long> {

}
