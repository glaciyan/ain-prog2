package cc.glaciyan.drawing;

import de.ketra.aufgabe5.PythagorasBaum;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Repräsentiert ein Rechteck mit vier Eckpunkten.
 */
public final class Rect {
    private final Point2 a; // 1. ecke
    private final Point2 b; // 2.
    private final Point2 c; // 3.
    private final Point2 d; // 4.

    /**
     * Konstruiert ein Rechteck aus 4 Eckpunkten.
     * @param a Der untere linke Punkt.
     * @param b Der untere rechte Punkt.
     * @param c Der obere rechte Punkt.
     * @param d Der obere linke Punkt.
     */
    public Rect(Point2 a, Point2 b, Point2 c, Point2 d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * Konstruiert ein Rechteck.
     * @param x Die x Koordinate der unteren linken Ecke.
     * @param y Die y Koordinate der unteren linken Ecke.
     * @param w Die breite und länge des Rechtecks.
     * @param gamma Der winkel vom boden zur unteren Kante.
     */
    public Rect(double x, double y, double w, double gamma) {
        double ang = Math.toRadians(gamma);
        double s = w * Math.sin(ang);
        double c = w * Math.cos(ang);

        this.a = new Point2(x, y);
        this.b = new Point2(x + c, y + s);
        this.c = new Point2(x + c - s, y + s + c);
        this.d = new Point2(x - s, y + c);
    }

    /**
     * Konstruiert ein Rechteck aus 2 Eckpunkten.
     * @param a Der untere Linke Punkt von Rechteck.
     * @param b Der untere Rechte Punkt von Rechteck.
     * @return Ein {@link Rect} aus den 2 Eckpunkten
     */
    public static Rect valueOf(Point2 a, Point2 b) {
        double gegenKathete = b.getY() - a.getY();
        double anKathete = b.getX() - a.getX();

        double ang = Math.toDegrees(Math.atan2(gegenKathete, anKathete));
        double w = Math.sqrt(gegenKathete * gegenKathete + anKathete * anKathete);

        return new Rect(a.getX(), a.getY(), w, ang);
    }

    /**
     * Konstruiert ein Rechteck aus 2 Eckpunkten.
     * @param x1 Die x Koordinate von der unteren Linken Ecke.
     * @param y1 Die y Koordinate von der unteren Linken Ecke.
     * @param x2 Die x Koordinate von der unteren Reckten Ecke.
     * @param y2 Die y Koordinate von der unteren Reckten Ecke.
     * @return Ein {@link Rect} aus den 2 Eckpunkten
     */
    public static Rect valueOf(double x1, double y1, double x2, double y2) {
        return Rect.valueOf(new Point2(x1, y1), new Point2(x2, y2));
    }

    /**
     * Rechnet die Gegenkathete aus.
     * @return Die Gegenkathete.
     */
    private double getGegenkathete() {
        return this.b.getY() - this.a.getY();
    }


    /**
     * Rechnet die Ankathete aus.
     * @return Die Ankathete.
     */
    private double getAnkathete() {
        return this.b.getX() - this.a.getX();
    }

    /**
     * Rechnet die breite und höhe von Rechteck aus.
     * @return Die breite und höhe.
     */
    public double getWidth() {
        double gegenKathete = getGegenkathete();
        double anKathete = getAnkathete();

        return Math.sqrt(gegenKathete * gegenKathete + anKathete * anKathete);
    }

    /**
     * Rechnet den Winkel vom Boden zur unteren Ecke aus.
     * @return Der Winkel vom Boden zue unteren Ecke.
     */
    public double getGamma() {
        double gegenKathete = getGegenkathete();
        double anKathete = getAnkathete();

        return Math.toDegrees(Math.atan2(gegenKathete, anKathete));
    }

    /**
     * Rechnet den Dreieckpunkt E aus.
     * @param delta Den Winkel vom Dreieck.
     * @return Ein {@link Point2} E für das Dreieck.
     */
    public Point2 getE(double delta) {
        var del = Math.toRadians(delta);
        var w = getWidth();
        double u = w * Math.cos(del);
        double v = w * Math.sin(del);

        var gamma = Math.toRadians(getGamma());

        return new Point2(d.getX() + u * Math.cos(del + gamma), d.getY() + u * Math.sin(del + gamma));
    }

    /**
     * Zeichnet das Rechteck auf dem Bildschirm.
     */
    public void draw() {
        StdDraw.polygon(new double[]{a.getX(), b.getX(), c.getX(), d.getX()}, new double[]{a.getY(), b.getY(), c.getY(), d.getY()});
    }

    /**
     * Zeichnet alle Eckpunkte auf dem Bildschirm.
     * <p>Die Farben sind wie folgt:</p>
     * <ul>
     * <li>A -> Blau</li>
     * <li>B -> Grün</li>
     * <li>C -> Rot</li>
     * <li>D -> Magenta</li>
     * </ul>
     */
    public void drawPoints() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);
        getA().draw();
        StdDraw.setPenColor(StdDraw.GREEN);
        getB().draw();
        StdDraw.setPenColor(StdDraw.RED);
        getC().draw();
        StdDraw.setPenColor(StdDraw.MAGENTA);
        getD().draw();
        PythagorasBaum.resetDraw();
    }

    /**
     * Gibt den punkt A.
     * @return {@link Point2} A
     */
    public Point2 getA() {
        return a;
    }

    /**
     * Gibt den punkt B.
     * @return {@link Point2} B
     */
    public Point2 getB() {
        return b;
    }

    /**
     * Gibt den punkt C.
     * @return {@link Point2} C
     */
    public Point2 getC() {
        return c;
    }

    /**
     * Gibt den punkt D.
     * @return {@link Point2} D
     */
    public Point2 getD() {
        return d;
    }

}
