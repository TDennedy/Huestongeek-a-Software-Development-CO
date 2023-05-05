package cse.data.pojo.trailforks;

import java.util.List;

import cse.data.pojo.GeoJSON;
import cse.data.repo.pojo.Feature;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a FeatureCollection in GeoJson from TrailForks.
 */
@Getter
@Setter
@NoArgsConstructor
public class TFGeoJSON extends GeoJSON {
	private List<TFGeoJSONFeature> features;
	
	public TFGeoJSON(List<Feature> features) {
		super(features);
	}
}
