package cse201.data.pojo;

import java.util.List;

import cse201.data.repo.pojo.FeatureGeo;
import lombok.Getter;

/**
 * Represents a Feature's geometry in GeoJson.
 * 
 * Just a DTO version of {@link FeatureGeo} to create correctly formatted GeoJson.
 * @author Sam
 *
 */
@Getter
public class GeoJSONFeatureGeometry {
	private String type;
		
	private List<?>	coordinates;
	
	public GeoJSONFeatureGeometry(FeatureGeo geom) {
		this.type = geom.getGeoType().toString();
		this.coordinates = geom.getCoordinates();
	}
}
