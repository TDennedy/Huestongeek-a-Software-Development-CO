package cse201.data.pojo.trailforks;

import java.util.List;

import lombok.Data;

/**
 * Represents a Feature's geometry in GeoJson from TrailForks.
 *
 */
@Data
public class TFGeoJSONFeatureGeometry {
	private String type;
	
	private String encodedpath;
	private List<?>	coordinates;
}
