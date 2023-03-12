package cse201.data.pojo;

import java.util.List;

import cse201.data.repo.pojo.Feature;
import lombok.Getter;

/**
 * Represents a FeatureCollection in GeoJSON.
 * @author Sam
 *
 */
@Getter
public class GeoJSON {
	private final String type = "FeatureCollection";
	
	private List<GeoJSONFeature> features;
	
	public GeoJSON(List<Feature> features) {
		final List<GeoJSONFeature> convertedFeatures = features
				.stream()
				.map(f -> new GeoJSONFeature(f))
				.toList();
		
		this.features = convertedFeatures;
	}
}
