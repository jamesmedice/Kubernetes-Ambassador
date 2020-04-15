package com.medici.app.shop.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@RedisHash("Operation")
public class Product implements Serializable {

	@Id
	private Long id;

	private String name;

	private String description;

	private BigDecimal price;

	private Long timestamp;
}
