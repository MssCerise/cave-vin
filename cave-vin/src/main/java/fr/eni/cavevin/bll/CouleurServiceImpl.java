package fr.eni.cavevin.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.cavevin.bo.Couleur;
import fr.eni.cavevin.dal.CouleurRepository;
import fr.eni.cavevin.exception.BusinessException;

@Service
public class CouleurServiceImpl implements CouleurService {
	// injection de la couche DAL
	private CouleurRepository repository;

	@Autowired
	public CouleurServiceImpl(CouleurRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Couleur> getListeCouleurs() {
		return repository.findAll();
	}

	@Override
	public Couleur getCouleur(int id) {
		Optional<Couleur> op = repository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			BusinessException be = new BusinessException();
			be.addError("La couleur n'existe pas (id: " + id + ")");
			throw be;
		}
	}

}
