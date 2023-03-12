package cse201.data.repo.pojo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import cse201.data.pojo.trailforks.TFGeoJSONFeature;
import cse201.toolkit.PolylineDecoder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(schema = "hiking", name = "feature")
public class Feature {
	@Id
	@Column(name = "id")
	private UUID 		id = UUID.randomUUID();
	
	@Column(name = "collection_id")
	private UUID		collectionID;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private FeatureGeo	geometry;
	
	// GeoJSON properties have no structure to them, especially if we pull from trailforks.
	// May want to turn this into its own object and only keep necessary properties?
	@Column
	@JdbcTypeCode(SqlTypes.JSON)
	private Map<String, ?> 
						properties;
	
	public Feature(TFGeoJSONFeature tf, UUID collectionID) {
		this.collectionID = collectionID;
		this.properties = tf.getProperties();

		final var geom = tf.getGeometry();
		List<?> coords = geom.getCoordinates();
		
		if (coords == null) coords = PolylineDecoder.decode(geom.getEncodedpath());
		
		this.geometry = new FeatureGeo(id, coords, geom.getType());
	}
}