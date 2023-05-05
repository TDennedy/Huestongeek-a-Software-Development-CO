package cse.data.pojo.trailforks;

import cse.data.pojo.GeoJSONFeatureGeometry;
import cse.data.repo.pojo.FeatureGeo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Feature's geometry in GeoJson from TrailForks.
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class TFGeoJSONFeatureGeometry extends GeoJSONFeatureGeometry {
	private String encodedpath;
	
	public TFGeoJSONFeatureGeometry(FeatureGeo geom) {
		super(geom);
	}
}
