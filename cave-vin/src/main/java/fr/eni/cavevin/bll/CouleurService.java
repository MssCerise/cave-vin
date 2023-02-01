package fr.eni.cavevin.bll;

import java.util.List;

import fr.eni.cavevin.bo.Couleur;

public interface CouleurService {
	List<Couleur> getListeCouleurs();

	Couleur getCouleur(int id);
}
