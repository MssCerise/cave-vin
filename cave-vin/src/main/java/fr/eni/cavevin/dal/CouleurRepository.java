package fr.eni.cavevin.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.cavevin.bo.Couleur;

public interface CouleurRepository extends JpaRepository<Couleur, Integer>{

}
