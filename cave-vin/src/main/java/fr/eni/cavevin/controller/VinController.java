package fr.eni.cavevin.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.cavevin.bll.BouteilleService;
import fr.eni.cavevin.bo.Bouteille;
import fr.eni.cavevin.exception.BusinessException;

@RestController
@RequestMapping("/vins")
@CrossOrigin
public class VinController {
	// Injection des services
	private BouteilleService bouteilleService;

	@Autowired
	public VinController(BouteilleService bouteilleService) {
		this.bouteilleService = bouteilleService;
	}

	@GetMapping
	public List<Bouteille> findAll() {
		return bouteilleService.getListBouteilles();
	}

	@GetMapping("/{id}")
	public Bouteille findById(@PathVariable int id) {
		return bouteilleService.getBouteille(id);
	}

	@PostMapping
	public Bouteille addBouteille(@Valid @RequestBody Bouteille theBouteille, BindingResult br) {
		if (br.hasErrors()) {
			System.out.println("addBouteille - error - " + br.getAllErrors());
			BusinessException be = new BusinessException();
			be.addError(br.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			throw be;
		} else {
			System.out.println(theBouteille);
			// id = 0
			theBouteille.setId(0);
			bouteilleService.save(theBouteille);
			return theBouteille;
		}
	}

	@PutMapping
	public Bouteille putBouteille(@RequestBody Bouteille theBouteille) {
		bouteilleService.save(theBouteille);
		return theBouteille;
	}

	@DeleteMapping("/{id}")
	public String deleteBouteille(@PathVariable int id) {
		bouteilleService.delete(id);
		return "Suppression bouteille id - " + id;
	}
	
	@GetMapping("/tri/nom/asc")
	public List<Bouteille> triParNomAsc(){
		return bouteilleService.triParNomAsc();
	}
	
	@GetMapping("/tri/nom/desc")
	public List<Bouteille> triParNomDesc(){
		return bouteilleService.triParNomDesc();
	}
	
	@GetMapping("/tri/mill/asc")
	public List<Bouteille> triParMillAsc() {
		return bouteilleService.triParMillesimeAsc();
	}
	
	@GetMapping("/tri/mill/desc")
	public List<Bouteille> triParMillDesc() {
		return bouteilleService.triParMillesimeDesc();
	}
	
	@GetMapping("/tri/petill/asc")
	public List<Bouteille> triParPetillantAsc() {
		return bouteilleService.triParPetillantAsc();
	}
	
	@GetMapping("/tri/petill/desc")
	public List<Bouteille> triParPetillantDesc() {
		return bouteilleService.triParPetillantDesc();
	}
	
	@GetMapping("/tri/quantite/asc")
	public List<Bouteille> triParQuantiteAsc() {
		return bouteilleService.triParQuantiteAsc();
	}
	
	@GetMapping("/tri/quantite/desc")
	public List<Bouteille> triParQuantiteDesc() {
		return bouteilleService.triParQuantiteDesc();
	}
	
	
	@GetMapping("/tri/couleur/asc")
	public List<Bouteille> triParCouleurAsc() {
		return bouteilleService.triParCouleurAsc();
	}
	
	@GetMapping("/tri/couleur/desc")
	public List<Bouteille> triParCouleurDesc() {
		return bouteilleService.triParCouleurDesc();
	}
	
	@GetMapping("/tri/region/asc")
	public List<Bouteille> triParRegionAsc() {
		return bouteilleService.triParRegionAsc();
	}
	
	@GetMapping("/tri/region/desc")
	public List<Bouteille> triParRegionDesc() {
		return bouteilleService.triParRegionDesc();
	}
}
