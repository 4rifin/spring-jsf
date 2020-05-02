package com.jsf.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.dao.BusRepository;
import com.jsf.model.Bus;

@Service
@Transactional
public class BusService {
	@Autowired
	private BusRepository busRepository;

	public List<Bus> findAll() {
		return busRepository.findAll();
	}

	public Bus save(Bus bus) {
		return busRepository.save(bus);
	}

	public void delete(Bus bus) {
		busRepository.delete(bus);
	}

	public boolean validation() {
		boolean result = false;

		if (findAll().size() < 10) {
			result = true;
		}
		return result;
	}
}
