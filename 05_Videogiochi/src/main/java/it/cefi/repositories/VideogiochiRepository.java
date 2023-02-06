package it.cefi.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.cefi.models.Videogioco;

public interface VideogiochiRepository extends CrudRepository<Videogioco, Integer>{

	@Query(value = "from Videogioco where titolo like :titolo%")
	public Iterable<Videogioco> searchvideogiochi(String titolo);
	
}
