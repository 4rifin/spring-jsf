package com.jsf.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String busOperationName;
	private String fromBusTerminal;
	private String toBusTerminal;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduledDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date estimatedDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualDateTime;

    
}
