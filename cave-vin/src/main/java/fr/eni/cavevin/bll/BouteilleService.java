package fr.eni.cavevin.bll;

import java.util.List;

import fr.eni.cavevin.bo.Bouteille;

public interface BouteilleService {
	List<Bouteille> getListBouteilles();

	Bouteille getBouteille(int id);

	void save(Bouteille b);

	void delete(int id);

	// Filtres
	List<Bouteille> triParNomAsc();

	List<Bouteille> triParNomDesc();

	List<Bouteille> triParPetillantAsc();

	List<Bouteille> triParPetillantDesc();

	List<Bouteille> triParMillesimeAsc();

	List<Bouteille> triParMillesimeDesc();

	List<Bouteille> triParQuantiteAsc();

	List<Bouteille> triParQuantiteDesc();

	List<Bouteille> triParCouleurAsc();

	List<Bouteille> triParCouleurDesc();

	List<Bouteille> triParRegionAsc();

	List<Bouteille> triParRegionDesc();
}
