package cc.glaciyan.drawing;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Repräsentiert ein Punkt im Raum mit einer x und y Koordinate.
 */
public record Point2(double x, double y) {
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
     *
     * @param s Der {@link String} zum Konvertieren.
     * @return Ein {@link Point2} mit den gegebenen Werten.
     */
    public static Point2 valueOf(String s) {
        Scanner sc = new Scanner(s);
        if (!sc.hasNext(FORMAT)) {
            throw new NumberFormatException(s);
        }

        sc.useDelimiter(",");
        sc.useLocale(Locale.US); // double mit punkt
        return new Point2(sc.nextDouble(), sc.nextDouble());
    }

    private static final Pattern FORMAT = Pattern.compile("^\\d+(\\.\\d+)?,\\d+(\\.\\d+)?$");

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
        return "%.4f,%.4f".formatted(this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2 point2 = (Point2) o;

        if (Double.compare(point2.x, x) != 0) return false;
        return Double.compare(point2.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
