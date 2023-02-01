package fr.eni.cavevin.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.cavevin.bo.Bouteille;
import fr.eni.cavevin.dal.BouteilleRepository;
import fr.eni.cavevin.exception.BusinessException;

@Service
public class BouteilleServiceImpl implements BouteilleService {
	// injection de la couche DAL
	private BouteilleRepository repository;

	@Autowired
	public BouteilleServiceImpl(BouteilleRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Bouteille> getListBouteilles() {
		return repository.findAll();
	}

	@Override
	public Bouteille getBouteille(int id) {
		Optional<Bouteille> op = repository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			BusinessException be = new BusinessException();
			be.addError("La bouteille est inconnue (id: " + id + ")");
			throw be;
		}
	}

	@Override
	public void save(Bouteille b) {
		BusinessException be = new BusinessException();
		if(b == null) {
			be.addError("Il faut au moins une bouteille");
		}
		validateNom(b.getNom(), be);
		validateQuantite(b.getQuantite(), b.getId(), be);
		if (b.getCouleur() == null) {
			be.addError("Veuillez sélectionner une couleur");
		}
		if (b.getRegion() == null) {
			be.addError("Veuillez sélectionner une région");
		}

		if (be.isError()) {
			throw be;
		}

		repository.save(b);

	}

	private void validateNom(String data, BusinessException be) {
		if (data == null || data.isBlank() || !data.isBlank() && (data.length() < 5 || data.length() > 50)) {
			be.addError("Le nom est obligatoire et il contient entre 5 et 50 caractères");
		}
	}

	private void validateQuantite(int data, int id, BusinessException be) {
		// Nouvelle bouteille : id = 0 & data > 0
		// Bouteille existante : id > 0 & data >= 0
		if (id == 0 && data <= 0 || id > 0 && data < 0) {
			be.addError("Votre quantité de bouteilles est insuffisante");
		}
	}

	@Override
	public void delete(int id) {
		BusinessException be = new BusinessException();
		if(id == 0) {
			be.addError("Identifiant inconnu");
			throw be;
		}
		Bouteille current = getBouteille(id);		
		repository.delete(current);
	}

	@Override
	public List<Bouteille> triParNomAsc() {
		return repository.findAllByOrderByNomAsc();
	}

	@Override
	public List<Bouteille> triParNomDesc() {
		return repository.findAllByOrderByNomDesc();
	}

	@Override
	public List<Bouteille> triParPetillantAsc() {
		return repository.findAllByOrderByPetillantAsc();
	}

	@Override
	public List<Bouteille> triParPetillantDesc() {
		return repository.findAllByOrderByPetillantDesc();
	}

	@Override
	public List<Bouteille> triParMillesimeAsc() {
		return repository.findAllByOrderByMillesimeAsc();
	}

	@Override
	public List<Bouteille> triParMillesimeDesc() {
		return repository.findAllByOrderByMillesimeDesc();
	}

	@Override
	public List<Bouteille> triParQuantiteAsc() {
		return repository.findAllByOrderByQuantiteAsc();
	}

	@Override
	public List<Bouteille> triParQuantiteDesc() {
		return repository.findAllByOrderByQuantiteDesc();
	}

	@Override
	public List<Bouteille> triParCouleurAsc() {
		return repository.findAllByOrderByCouleurAsc();
	}

	@Override
	public List<Bouteille> triParCouleurDesc() {
		return repository.findAllByOrderByCouleurDesc();
	}

	@Override
	public List<Bouteille> triParRegionAsc() {
		return repository.findAllByOrderByRegionAsc();
	}

	@Override
	public List<Bouteille> triParRegionDesc() {
		return repository.findAllByOrderByRegionDesc();
	}

}
