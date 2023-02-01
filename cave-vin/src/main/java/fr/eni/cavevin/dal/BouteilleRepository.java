package fr.eni.cavevin.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.cavevin.bo.Bouteille;

public interface BouteilleRepository extends JpaRepository<Bouteille, Integer>{
	List<Bouteille> findAllByOrderByNomAsc();
	List<Bouteille> findAllByOrderByNomDesc();
	List<Bouteille> findAllByOrderByPetillantAsc();
	List<Bouteille> findAllByOrderByPetillantDesc();
	List<Bouteille> findAllByOrderByMillesimeAsc();
	List<Bouteille> findAllByOrderByMillesimeDesc();
	List<Bouteille> findAllByOrderByQuantiteAsc();
	List<Bouteille> findAllByOrderByQuantiteDesc();
	List<Bouteille> findAllByOrderByCouleurAsc();
	List<Bouteille> findAllByOrderByCouleurDesc();
	List<Bouteille> findAllByOrderByRegionAsc();
	List<Bouteille> findAllByOrderByRegionDesc();
}
