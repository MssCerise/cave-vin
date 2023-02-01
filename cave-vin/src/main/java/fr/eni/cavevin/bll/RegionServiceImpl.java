package fr.eni.cavevin.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.cavevin.bo.Region;
import fr.eni.cavevin.dal.RegionRepository;
import fr.eni.cavevin.exception.BusinessException;

@Service
public class RegionServiceImpl implements RegionService {
	// injection de la couche DAL
	private RegionRepository repository;

	@Autowired
	public RegionServiceImpl(RegionRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Region> getListeRegions() {
		return repository.findAll();
	}

	@Override
	public Region getRegion(int id) {
		Optional<Region> op = repository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			BusinessException be = new BusinessException();
			be.addError("La région n'existe pas (id: " + id + ")");
			throw be;
		}
	}

}
