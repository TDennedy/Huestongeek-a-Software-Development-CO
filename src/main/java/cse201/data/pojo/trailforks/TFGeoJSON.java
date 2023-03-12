package cse201.data.pojo.trailforks;

import java.util.List;

import lombok.Data;

/**
 * Represents a FeatureCollection in GeoJson from TrailForks.
 */
@Data
public class TFGeoJSON {
	private final String type = "FeatureCollection";
	
	private List<TFGeoJSONFeature> features;
}
