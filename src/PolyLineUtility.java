import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Copyright 2023
 * File: PolyLineUtility
 *
 * @author Jack Roach (Github: jackdroach)
 */
public class PolyLineUtility {

    /**
     * Program entry point
     *
     * @param args directory
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("java -cp src PolyLineUtility [dir]");
        }

        File dir = new File(args[0]);

        String[] names = dir.list((dir1, name) -> (name.endsWith(".gps")));

        if (names == null) {
            System.out.println("No valid files found.");
            System.exit(0);
        }

        Scanner in;
        for (String s : names) {
            try {
                in = new Scanner(new File(dir.getName() + "/" + s));

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            ArrayList<Point> points = new ArrayList<>();

            while (in.hasNext()) {
                points.add(new Point(in.nextDouble(), in.nextDouble()));
            }

            System.out.println(s.substring(0, s.length() - 4) + " " +
                new PolyLine(points).encode());
        }
    }

}
