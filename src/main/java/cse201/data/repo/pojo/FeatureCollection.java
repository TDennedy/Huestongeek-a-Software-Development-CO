package cse201.data.repo.pojo;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import cse201.data.pojo.trailforks.TFGeoJSON;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "hiking", name = "feature_collection")

@Getter
@Setter
@NoArgsConstructor
public class FeatureCollection {
	@Id
	@Column
	private UUID id = UUID.randomUUID();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "collection_id", insertable = false, updatable = false)
	@Fetch(FetchMode.SUBSELECT)
	private List<Feature> features;
	
	@Column
	private String name;
	
	public FeatureCollection(String name, TFGeoJSON geoJson) {
		this.features = geoJson.getFeatures()
				.stream()
				.map(tf -> new Feature(tf, id))
				.toList();
		
		this.name = name;
	}
}
