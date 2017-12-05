package com.example.mongo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class TestData extends AbstractEntity {

	public static final String TEST_UUID = "TEST_UUID";
	private String value;

}
