package cse201.data.pojo.trailforks;

import java.util.Map;

import lombok.Data;

/**
 * Represents a Feature in GeoJson from TrailForks..
 *
 */
@Data
public class TFGeoJSONFeature {
	private final String	type = "Feature";
	
	private TFGeoJSONFeatureGeometry	
							geometry;
	
	private Map<String, ?> 	properties;
}