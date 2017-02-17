package com.gd.spring.repositories;

import com.gd.spring.models.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
