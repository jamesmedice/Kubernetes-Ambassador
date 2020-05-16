package com.medici.app.storage.domain.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.medici.app.storage.domain.model.Operation;

@CrossOrigin
@Cacheable
@RepositoryRestResource(collectionResourceRel = "operations", path = "operations")
public interface OperationRepository extends CrudRepository<Operation, Long> {

}
