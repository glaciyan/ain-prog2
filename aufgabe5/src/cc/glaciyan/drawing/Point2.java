package cc.glaciyan.drawing;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Repräsentiert ein Punkt im Raum mit einer x und y Koordinate.
 */
public record Point2(double x, double y) implements Comparable<Point2> {
    /**
     * Ein Punkt am Uhrsprung.
     */
    public static final Point2 ZERO = new Point2(0, 0);

    /**
     * Konstruiert ein {@link Point2} mit einer x und y Koordinate.
     *
     * @param x Die x Koordinate.
     * @param y Die y Koordinate.
     */
    public Point2 {
    }

    /**
     * Konvertiert ein {@link String} zu einem {@link Point2}.
     * @param s Der {@link String} zum Konvertieren.
     * @return Ein {@link Point2} mit den gegebenen Werten.
     */
    public static Point2 valueOf(String s) {
        Scanner sc = new Scanner(s);
        if (!sc.hasNext(FORMAT)) {
            throw new NumberFormatException(s);
        }

        sc.useDelimiter(",");
        return new Point2(sc.nextDouble(), sc.nextDouble());
    }

    // TODO: no double support
    private static final Pattern FORMAT = Pattern.compile("^\\(\\d+,\\s*\\d+\\)$");

    /**
     * Zeichnet den Punkt auf den Bildschirm.
     */
    public void draw() {
        StdDraw.point(this.x, this.y);
    }

    /**
     * Gibt eine {@link String} repräsentation von dem Punkt.
     *
     * @return Ein {@link String} von dem Punkt.
     */
    @Override
    public String toString() {
        return "(%f, %f)".formatted(this.x, this.y);
    }

    @Override
    public int compareTo(Point2 o) {
        return 0;
    }

    /**
     * Gibt die x Koordinate.
     *
     * @return Die x Koordinate.
     */
    @Override
    public double x() {
        return x;
    }

    /**
     * Gibt die y Koordinate.
     *
     * @return Die y Koordinate.
     */
    @Override
    public double y() {
        return y;
    }
}
