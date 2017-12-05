package com.example.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class PAbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
}
