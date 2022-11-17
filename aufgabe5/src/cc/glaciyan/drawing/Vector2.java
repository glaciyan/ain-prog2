package cc.glaciyan.drawing;

import edu.princeton.cs.introcs.StdDraw;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Repräsentiert ein Vektor im Raum mit einer x und y Koordinate.
 */
public record Vector2(double x, double y) {
    /**
     * Ein Vektor am Uhrsprung.
     */
    public static final Vector2 ZERO = new Vector2(0, 0);
    private static final Pattern FORMAT = Pattern.compile("^\\d+(\\.\\d+)?,\\d+(\\.\\d+)?$");

    /**
     * Konstruiert ein {@link Vector2} mit einer x und y Koordinate.
     *
     * @param x Die x Koordinate.
     * @param y Die y Koordinate.
     */
    public Vector2 {
    }

    /**
     * Konvertiert ein {@link String} zu einem {@link Vector2}.
     *
     * @param s Der {@link String} zum Konvertieren.
     * @return Ein {@link Vector2} mit den gegebenen Werten.
     */
    public static Vector2 valueOf(String s) {
        Scanner sc = new Scanner(s);
        if (!sc.hasNext(FORMAT)) {
            throw new NumberFormatException(s);
        }

        sc.useDelimiter(",");
        sc.useLocale(Locale.US); // double mit punkt
        return new Vector2(sc.nextDouble(), sc.nextDouble());
    }

    /**
     * Zeichnet den Vektor als Punkt auf den Bildschirm.
     */
    public void draw() {
        StdDraw.point(this.x, this.y);
    }

    /**
     * Gibt eine {@link String} repräsentation von dem Vektor.
     *
     * @return Ein {@link String} von dem Vektor.
     */
    @Override
    public String toString() {
        return "%.4f,%.4f".formatted(this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector2 vector2 = (Vector2) o;

        if (Double.compare(vector2.x, x) != 0) return false;
        return Double.compare(vector2.y, y) == 0;
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
     * Multipliziert den Vektor um einen Wert.
     */
    public Vector2 mul(double v) {
        return new Vector2(x * v, y * v);
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
