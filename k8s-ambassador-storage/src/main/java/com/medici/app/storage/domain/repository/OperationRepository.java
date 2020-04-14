package com.medici.app.storage.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.medici.app.storage.domain.model.Operation;

public interface OperationRepository extends CrudRepository<Operation, Long> {
}
