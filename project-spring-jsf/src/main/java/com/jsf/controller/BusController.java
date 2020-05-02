package com.jsf.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsf.model.Bus;
import com.jsf.service.BusService;

@Named
@ViewScoped
public class BusController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 581453877192605965L;

	private Bus bus = new Bus();

	private List<Bus> listBus = new ArrayList<>();

	@Autowired
	private BusService busService;

	@PostConstruct
    public void init(){
		fetchAll();
    }
	
	public void fetchAll() {
		listBus = busService.findAll();
	}

	public void save() {
		String message = "";
		if(busService.validation()) {
			busService.save(bus);
			bus = new Bus();
			fetchAll();
			message = "Succes Save";
		}else {
			message = "Failed Save";
		}
		message(message);
			
	}
	
	public void message(String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage(message.contains("Failed") ? FacesMessage.SEVERITY_ERROR : FacesMessage.SEVERITY_INFO,
						"Message", message));
	}

	public void delete(Bus bus) {
		busService.delete(bus);
		fetchAll();
		message("Succes Delete");
	}
	
	public void edit(Bus bus) {
		this.bus = bus;
	}

	public void refresh() {
		bus = new Bus();
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public List<Bus> getListBus() {
		return listBus;
	}

	public void setListBus(List<Bus> listBus) {
		this.listBus = listBus;
	}

	public BusService getBusService() {
		return busService;
	}

	public void setBusService(BusService busService) {
		this.busService = busService;
	}
	
}
