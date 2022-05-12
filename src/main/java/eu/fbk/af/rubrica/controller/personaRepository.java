package eu.fbk.af.rubrica.controller;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// import org.springframework.data.repository.Repository;
import eu.fbk.af.rubrica.model.Persona;

@Repository
public interface personaRepository extends MongoRepository<Persona, String>{
	List<Persona> findByCodiceFiscale(String codiceFiscale);

    List<Persona> findByNome(String nome);



}