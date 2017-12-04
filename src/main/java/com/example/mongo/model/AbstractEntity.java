package com.example.mongo.model;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
public abstract class AbstractEntity {

	@Id
	protected String id;
}
