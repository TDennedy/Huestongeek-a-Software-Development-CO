package cse.toolkit;

import java.util.ArrayList;
import java.util.List;

import com.mapbox.geojson.Point;
import com.mapbox.geojson.utils.PolylineUtils;

public class PolylineToolkit {
	private static final int DEFAULT_PRECISION = 5;

	//    public List<Point> decode(String encoded) {
	//        return decode(encoded, DEFAULT_PRECISION);
	//    }
	
	public static void main(String[] args) {
		String x = "r}edO}cppFs^gS_U`YiCmj@bm@wBlx@_KaGuN";
		for (double[] y : decode(x)) System.out.println(y[0] + ", " + y[1]);
	}
	
	public static String encode(List<double[]> points) {
		return PolylineUtils.encode(toPoints(points), DEFAULT_PRECISION);
	}

    public static List<double[]> decode(String encoded) {
    	final List<Point> points = PolylineUtils.decode(encoded, DEFAULT_PRECISION);
    	
    	return fromPoints(points);
    }
    
    public static List<double[]> fromPoints(List<Point> points) {
    	return points.stream()
    			.map(point -> new double[] {point.longitude(), point.latitude()})
    			.toList();
    }
    
    public static List<Point> toPoints(List<double[]> coords) {
    	final List<Point> points = new ArrayList<Point>(coords.size());
    	
    	for (double[] coord : coords)
    		points.add(Point.fromLngLat(coord[0], coord[1]));
    	
    	return points;
    }
}