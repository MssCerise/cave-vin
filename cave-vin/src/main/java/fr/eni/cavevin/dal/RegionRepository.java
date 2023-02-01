package fr.eni.cavevin.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.cavevin.bo.Region;

public interface RegionRepository extends JpaRepository<Region, Integer>{

}
