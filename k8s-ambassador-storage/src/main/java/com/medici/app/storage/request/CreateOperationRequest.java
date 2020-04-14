package com.medici.app.storage.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOperationRequest {
	// @NotNull(message = "{constraints.NotEmpty.message}")
	// private String id;

	@NotNull(message = "{constraints.NotEmpty.message}")
	private String num1;

	@NotNull(message = "{constraints.NotEmpty.message}")
	private String num2;

	@NotNull(message = "{constraints.NotEmpty.message}")
	private String op;

	@NotNull(message = "{constraints.NotEmpty.message}")
	private String result;
}
