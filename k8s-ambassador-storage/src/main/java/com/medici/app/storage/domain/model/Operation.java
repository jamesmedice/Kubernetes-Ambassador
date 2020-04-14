package com.medici.app.storage.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@NoArgsConstructor
@RedisHash("Operation")
public class Operation {
	@Id
	private Long id;
	private Long timestamp;
	private String num1;
	private String num2;
	private String op;
	private String result;

	@Override
	public String toString() {
		return num1.concat(" ").concat(op).concat(" ").concat(num2).concat(" = ").concat(result);
	}
}
