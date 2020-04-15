package com.medici.app.shop.request;

import java.math.BigDecimal;

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
public class CreateProductRequest {

	@NotNull(message = "can  not  be  null ")
	private String name;

	@NotNull(message = "can  not  be  null ")
	private String description;

	@NotNull(message = "can  not  be  null ")
	private BigDecimal price;
}
