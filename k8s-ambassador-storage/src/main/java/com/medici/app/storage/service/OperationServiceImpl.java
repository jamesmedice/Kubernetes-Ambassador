package com.medici.app.storage.service;

import java.time.Instant;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medici.app.storage.domain.model.Operation;
import com.medici.app.storage.domain.repository.OperationRepository;
import com.medici.app.storage.dto.OperationDto;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	OperationRepository operationRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public Operation createOperation(OperationDto operationDto) {
		Operation op = mapper.map(operationDto, Operation.class);
		op.setTimestamp(Instant.now().toEpochMilli());
		return operationRepository.save(op);
	}

	@Override
	public List<Operation> getAllOperations() {
		Iterator<Operation> iteratorToCollection = operationRepository.findAll().iterator();
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iteratorToCollection, Spliterator.ORDERED), false).collect(Collectors.toList());
	}

	@Override
	public void deleteOperation(OperationDto operationDto) {
		Operation op = mapper.map(operationDto, Operation.class);
		operationRepository.delete(op);
	}
}
