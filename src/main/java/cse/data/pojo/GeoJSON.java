package cse.data.pojo;

import java.util.List;

import cse.data.repo.pojo.Feature;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents a FeatureCollection in GeoJSON.
 * @author Sam
 *
 */
@Getter
@NoArgsConstructor
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
	
	// Custom getter so List's type can be subclass of GeoJSONFeature
	public List<? extends GeoJSONFeature> getFeatures() {
		return this.features;
	}
}
