package cse.data.repo.pojo;

public enum FeatureGeoType {
	POINT, LINE_STRING, POLYGON, MULTI_POINT, MULTI_LINE_STRING, MULTI_POLYGON;
	
	public static FeatureGeoType fromString(String str) {
		switch (str) {
		
		case "Point": 			return POINT;
		case "LineString": 		return LINE_STRING;
		case "Polygon": 		return POLYGON;
		case "MultiPoint": 		return MULTI_POINT;
		case "MultiLineString": return MULTI_LINE_STRING;
		case "MultiPolygon": 	return MULTI_POLYGON;
		default: 				return null;
		
		}
	}
	
	@Override
	public String toString() {
		switch (this) {
		
		case POINT: 			return "Point";
		case LINE_STRING: 		return "LineString";
		case POLYGON: 			return "Polygon";
		case MULTI_POINT: 		return "MultiPoint";
		case MULTI_LINE_STRING: return "MultiLineString";
		case MULTI_POLYGON: 	return "MultiPolygon";
		default: 				return null;
		
		}
	}
}
