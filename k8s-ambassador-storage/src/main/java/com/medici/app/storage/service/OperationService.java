package com.medici.app.storage.service;

import java.util.List;

import com.medici.app.storage.domain.model.Operation;
import com.medici.app.storage.dto.OperationDto;

public interface OperationService {
	Operation createOperation(OperationDto operationDto);

	List<Operation> getAllOperations();

	void deleteOperation(OperationDto operationDto);
}
