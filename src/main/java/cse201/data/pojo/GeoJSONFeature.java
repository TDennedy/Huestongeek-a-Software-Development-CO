package cse201.data.pojo;

import java.util.Map;

import cse201.data.repo.pojo.Feature;
import lombok.Getter;

/**
 * Represents a Feature in GeoJson.
 * 
 * Just a DTO version of {@link Feature} to create correctly formatted GeoJson.
 * @author Sam
 *
 */
@Getter
public class GeoJSONFeature {
	private final String	type = "Feature";
	
	private GeoJSONFeatureGeometry	
							geometry;
	
	private Map<String, ?> 	properties;

	@SuppressWarnings("unchecked")
	public GeoJSONFeature(Feature feature) {
		this.geometry = new GeoJSONFeatureGeometry(feature.getGeometry());
		this.properties = feature.getProperties();
		
		((Map<String, Object>) properties).put("id", feature.getId());
	}
}