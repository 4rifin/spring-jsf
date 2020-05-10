package com.jsf.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BusVO {
	private Long id;
	private String busOperationName;
	private String fromBusTerminal;
	private String toBusTerminal;
	private Date scheduledDateTime;
	private Date estimatedDateTime;
	private Date actualDateTime;

}
