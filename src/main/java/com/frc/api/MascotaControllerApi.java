package com.frc.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frc.data.MascotaRepository;
import com.frc.model.Mascota;

@RestController
@RequestMapping(path="/mascota", produces="application/json")
@CrossOrigin(origins="*")
public class MascotaControllerApi {
	
	@Autowired
	private MascotaRepository petRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<Mascota> petById(@PathVariable("id") Long id){
		Optional<Mascota> optPet = petRepo.findById(id);
		if (optPet.isPresent()) {
			return new ResponseEntity<>(optPet.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(optPet.get(), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(path="", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Mascota postPet(@RequestBody Mascota mascota) {
		return (petRepo).save(mascota);
	}
	
	@GetMapping("")
	public Iterable<Mascota> findAllPets(){
		return petRepo.findAll();
	}
	
	@GetMapping("/recents/twentyYoungest")
	public Iterable<Mascota> recentPetsOnePageTwentySortedDesc(){
		int pag = 0;
		int qtty = 20;
		PageRequest page = PageRequest.of(pag, qtty, Sort.by("fechaNac").descending());
		return petRepo.findAll(page);
	}
	
	@GetMapping("/recents/{pag}")
	public Iterable<Mascota> petResultFivePerPage(@PathVariable("pag") int pag){
		int qtty = 5;
		PageRequest page = PageRequest.of(pag, qtty);
		return petRepo.findAll(page);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMascota(@PathVariable("id") Long id) {
		petRepo.deleteById(id);
	}
	
	@GetMapping("/find/{name}")
	public ResponseEntity<Mascota> petByName(@PathVariable("name") String name){
		Optional<Mascota> optPet = petRepo.findByName(name);
		if (optPet.isPresent()) {
			return new ResponseEntity<>(optPet.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	
	
}
