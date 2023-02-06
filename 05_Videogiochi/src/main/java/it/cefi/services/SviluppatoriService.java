package it.cefi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.models.Sviluppatore;
import it.cefi.repositories.SviluppatoriRepository;

@Service
public class SviluppatoriService {
	
	@Autowired
	private SviluppatoriRepository sviluppatoriRepository;
	
	public Iterable<Sviluppatore> getSviluppatori() {
		return sviluppatoriRepository.findAll();
	}
	
	public Sviluppatore getSviluppatore(int id) {
		return sviluppatoriRepository.findById(id).get();
	}
	
	public void saveSviluppatore(Sviluppatore sviluppatore) {
		sviluppatoriRepository.save(sviluppatore);
	}
	
	public void deleteSviluppatore(int id) {
		sviluppatoriRepository.deleteById(id);
	}
	
}
