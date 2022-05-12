package eu.fbk.af.rubrica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eu.fbk.af.rubrica.model.Persona;



@RestController //???
public class PersonaController {

	private List<Persona> persone = new ArrayList<>();

	@Autowired
	private personaRepository personaRepository;
	
	@PostMapping ("/api/persona")//???
	public void add(@RequestBody Persona persona) {
		persone.add(persona);
	}
	
	@GetMapping("/api/persona")
	public @ResponseBody List<Persona> list(){
		return persone;
	}
	
	@GetMapping("/api/persona/{codiceFiscale}")
	public Persona get(@PathVariable String codiceFiscale) {
		return getPersonaByCodiceFiscale(persone, codiceFiscale);
	}
	
	@PutMapping("/api/persona")
	public void update(@RequestBody Persona persona) {
		Persona p = getPersonaByCodiceFiscale(persone, persona.getCodiceFiscale());
		if(p!=null) {
			persone.remove(p);
			persone.add(persona);
		}
		
	}
	
	@DeleteMapping ("/api/persona/{codiceFiscale}")
	public void delete(@PathVariable String codiceFiscale) {
		Persona p = getPersonaByCodiceFiscale(persone, codiceFiscale);
		if(p!=null) {
			persone.remove(p);
		}
	}
			
	private Persona getPersonaByCodiceFiscale(List<Persona> lista, String codiceFiscale) {
		for (Persona p : lista) {
			if (p.getCodiceFiscale().equals(codiceFiscale)) {
				return p;
			}
		}
		return null;
	}
}
