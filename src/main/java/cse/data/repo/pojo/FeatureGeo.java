package cse.data.repo.pojo;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import cse.data.pojo.Trail;
import cse.data.repo.pojo.converter.FeatureGeoTypeConverter;
import cse.toolkit.PolylineToolkit;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(schema = "hiking", name = "feature_geo")

@NoArgsConstructor
public class FeatureGeo {
	@Id
	@Column(name = "feature_id")
	private UUID featureID;
	
	@Column(name = "geo_type")
	@Convert(converter = FeatureGeoTypeConverter.class)
	private FeatureGeoType geoType;
	
	// We have to make this list generic; the structure can either be a single
	// coordinate pair (double[]) or multiple coordinate pairs (double[][])
	@Column
	@JdbcTypeCode(SqlTypes.JSON)	
	private List<?>	coordinates;
	
	public FeatureGeo(UUID featureID, List<?> coordinates, String geoType) {
		this.featureID = featureID;
		this.coordinates = coordinates;
		this.geoType = FeatureGeoType.fromString(geoType);
	}
	
	public FeatureGeo(UUID featureID, Trail trail) {
		this.featureID = featureID;
		this.coordinates = PolylineToolkit.decode(trail.getEncodedPolyline());
		this.geoType = FeatureGeoType.LINE_STRING;
	}
}
