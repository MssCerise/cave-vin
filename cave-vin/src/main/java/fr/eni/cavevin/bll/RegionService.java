package fr.eni.cavevin.bll;

import java.util.List;

import fr.eni.cavevin.bo.Region;

public interface RegionService {
	List<Region> getListeRegions();

	Region getRegion(int id);
}
