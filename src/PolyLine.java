import java.util.ArrayList;

/**
 * Copyright 2023
 * File: Polyline
 *
 * @author Jack Roach (Github: jackdroach)
 *
 * @param points Arraylist of points
 */
public record PolyLine(ArrayList<Point> points) {

    /**
     * Arraylist of points -> polyline encoded String
     * ({lat + lng}, {lat + lng}, ...).
     *
     * @return polyline encoded String ({lat + lng}, {lat + lng}, ...)
     */
    public String encode() {
        StringBuilder string = new StringBuilder();

        Encoder encoder = new Encoder();

        for (Point p : points) {
            string.append(encoder.encodePoint(p.lat(), p.lng()));
        }

        return string.toString();
    }

}
