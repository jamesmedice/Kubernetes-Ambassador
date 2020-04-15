package com.medici.app.storage.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medici.app.storage.domain.model.Operation;
import com.medici.app.storage.dto.OperationDto;
import com.medici.app.storage.request.CreateOperationRequest;
import com.medici.app.storage.service.OperationService;

@RestController
@RequestMapping("/bootstorage")
public class OperationController {

	@Autowired
	OperationService operationService;

	@Autowired
	ModelMapper mapper;

	@CrossOrigin
	@GetMapping(value = "/")
	public List<OperationDto> getOperations() {
		List<Operation> allOperations = operationService.getAllOperations();
		if (allOperations != null && !allOperations.isEmpty()) {
			return allOperations.stream().map(account -> mapper.map(account, OperationDto.class)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@CrossOrigin
	@GetMapping(value = "/operations")
	public List<String> getOperationsInStringForm() {
		List<Operation> allOperations = operationService.getAllOperations();
		if (allOperations != null && !allOperations.isEmpty()) {
			return allOperations.stream().sorted(Comparator.comparing(Operation::getTimestamp).reversed()).map(Object::toString).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@PostMapping(value = "/create")
	public OperationDto createOperation(@RequestBody @Valid CreateOperationRequest createOperationRequest) {
		OperationDto operationDto = mapper.map(createOperationRequest, OperationDto.class);
		Operation operation = operationService.createOperation(operationDto);
		if (operation != null) {
			return mapper.map(operation, OperationDto.class);
		}
		return null;
	}

	@GetMapping(value = "/deletelru")
	public ResponseEntity deleteOperation() {
		List<Operation> allOperations = operationService.getAllOperations();

		if (allOperations != null && !allOperations.isEmpty()) {
			List<Operation> sortedOperations = allOperations.stream().sorted(Comparator.comparing(Operation::getTimestamp)).collect(Collectors.toList());
			operationService.deleteOperation(mapper.map(sortedOperations.get(0), OperationDto.class));
			return new ResponseEntity(HttpStatus.OK);
		}

		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/healthz")
	public ResponseEntity healthz() {
		return new ResponseEntity(HttpStatus.OK);
	}
}
