package cse.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cse.data.pojo.GeoJSON;
import cse.data.repo.FeatureRepo;
import cse.data.repo.pojo.Feature;

@Service
public class GeoService {
	@Autowired
	private FeatureRepo repo;
	
	public Feature save(Feature feature) {
		// Set new ID for both
		feature.setId(UUID.randomUUID());
		feature.getGeometry().setFeatureID(feature.getId());
		
		return saveOrUpdate(feature);
	}
	
	public Feature saveOrUpdate(Feature feature) {
		return repo.saveAndFlush(feature);
	}
	
	public Feature getFeature(UUID id) {
		return repo.findById(id).get();
	}
	
	public GeoJSON getByCollection(UUID id) {
		final List<Feature> features = repo.findByCollectionId(id);
		
		return new GeoJSON(features);
	}
}
