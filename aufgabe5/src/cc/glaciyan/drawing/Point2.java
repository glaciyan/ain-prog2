package cc.glaciyan.drawing;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Repräsentiert ein Punkt im Raum mit einer x und y Koordinate.
 */
public class Point2 {
    private double x;
    private double y;

    /**
     * Konstruiert ein {@link Point2} mit einer x und y Koordinate.
     * @param x Die x Koordinate.
     * @param y Die y Koordinate.
     */
    public Point2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Konstruiert ein Punkt an (0, 0).
     */
    public Point2() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Gibt die x Koordinate.
     * @return Die x Koordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gibt die y Koordinate.
     * @return Die y Koordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Zeichnet den Punkt auf den Bildschirm.
     */
    public void draw() {
        StdDraw.point(this.x, this.y);
    }

    /**
     * Gibt eine {@link String} repräsentation von dem Punkt.
     * @return Ein {@link String} von dem Punkt.
     */
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
