package it.cefi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cefi.models.Videogioco;
import it.cefi.repositories.VideogiochiRepository;

@Service
public class VideogiochiService {
	
	@Autowired
	private VideogiochiRepository videogiochiRepository;
	
	public Iterable<Videogioco> getVideogiochi() {
		return videogiochiRepository.findAll();
	}
	
	public Videogioco getVideogioco(int id) {
		return videogiochiRepository.findById(id).get();
	}
	
	public void saveVideogioco(Videogioco sviluppatore) {
		videogiochiRepository.save(sviluppatore);
	}
	
	public void deleteVideogioco(int id) {
		videogiochiRepository.deleteById(id);
	}

	public Iterable<Videogioco> searchvideogiochi(String titolo){
		return videogiochiRepository.searchvideogiochi(titolo);
	}
	
}
