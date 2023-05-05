package cse.data.pojo;

import java.util.List;

import cse.data.repo.pojo.FeatureGeo;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents a Feature's geometry in GeoJson.
 * 
 * Just a DTO version of {@link FeatureGeo} to create correctly formatted GeoJson.
 * @author Sam
 *
 */
@Getter
@NoArgsConstructor
public class GeoJSONFeatureGeometry {
	private String type;
		
	private List<?>	coordinates;
	
	public GeoJSONFeatureGeometry(FeatureGeo geom) {
		this.type = geom.getGeoType().toString();
		this.coordinates = geom.getCoordinates();
	}
}
