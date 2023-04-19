package cse.data.repo.pojo.converter;

import static cse.data.repo.pojo.FeatureGeoType.*;

import cse.data.repo.pojo.FeatureGeoType;
import jakarta.persistence.AttributeConverter;


public class FeatureGeoTypeConverter implements AttributeConverter<FeatureGeoType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(FeatureGeoType geoType) {
		if (geoType == null)
			return null;

		switch (geoType) {
		
		case POINT: return 0;
		case LINE_STRING: return 1;
		case POLYGON: return 2;
		case MULTI_POINT: return 3;
		case MULTI_LINE_STRING: return 4;
		case MULTI_POLYGON: return 5;
			
		}
		
		throw new IllegalArgumentException(geoType + " not found.");
	}

	@Override
	public FeatureGeoType convertToEntityAttribute(Integer id) {
		if (id == null)
			return null;

		switch (id) {
		
		case 0: return POINT;
		case 1: return LINE_STRING;
		case 2: return POLYGON;
		case 3: return MULTI_POINT;
		case 4: return MULTI_LINE_STRING;
		case 5: return MULTI_POLYGON;
			
		}
		
		throw new IllegalArgumentException(id + " not supported.");
	}
}
