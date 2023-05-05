/**
 * Copyright 2023
 * File: Encoder
 *
 * @author Jack Roach (Github: jackdroach)
 */
public class Encoder {
    
    private int prevLat;
    private int prevLng;

    /**
     * Construct a new Encoder.
     */
    public Encoder() {
        prevLat = 0;
        prevLng = 0;
    }

    /**
     * Single Point (lat, lng) -> polyline encoded String (lat + lng).
     *
     * @param x lat
     * @param y lng
     * @return polyline encoded String (lat + lng)
     */
    public String encodePoint(double x, double y) {
        int lat = (int) Math.round(x * 1e5);
        int lng = (int) Math.round(y * 1e5);

        int eLat = lat - prevLat;
        int eLng = lng - prevLng;

        prevLat = lat;
        prevLng = lng;

        return encodeSignedNumber(eLat) + encodeSignedNumber(eLng);
    }

    /**
     * Signed int -> polyline encoded String.
     *
     * @param i signed int
     * @return polyline encoded String
     */
    private String encodeSignedNumber(int i) {
        int uNum = i << 1;

        if (i < 0) {
            uNum = ~(uNum);
        }

        return(encodeNumber(uNum));
    }

    /**
     * Unsigned int -> polyline encoded String.
     *
     * @param num unsigned int
     * @return polyline encoded String
     */
    private String encodeNumber(int num) {
        StringBuilder string = new StringBuilder();

        while (num >= 0x20) {
            int nextValue = (0x20 | (num & 0x1f)) + 63;
            string.append((char) nextValue);
            num >>= 5;
        }

        int val = num + 63;
        string.append((char) val);

        return string.toString();
    }

}