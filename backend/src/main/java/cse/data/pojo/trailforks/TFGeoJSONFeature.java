package cse.data.pojo.trailforks;

import cse.data.pojo.GeoJSONFeature;
import cse.data.repo.pojo.Feature;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Feature in GeoJson from TrailForks..
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class TFGeoJSONFeature extends GeoJSONFeature {
	private TFGeoJSONFeatureGeometry geometry;
	
	public TFGeoJSONFeature(Feature feature) {
		super(feature);
	}
}