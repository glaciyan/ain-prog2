package cc.glaciyan.drawing;

import de.ketra.aufgabe5.PythagorasBaum;
import edu.princeton.cs.introcs.StdDraw;

import java.util.Objects;

/**
 * Repräsentiert ein Rechteck mit vier Eckpunkten.
 */
public final class Rect {
    private final Vector2 a;
    private final Vector2 b;
    private final Vector2 c;
    private final Vector2 d;

    private Rect(Vector2 a, Vector2 b, Vector2 c, Vector2 d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * Konstruiert ein Rechteck.
     *
     * @param x     Die x Koordinate der unteren linken Ecke.
     * @param y     Die y Koordinate der unteren linken Ecke.
     * @param w     Die breite und höhe des Rechtecks.
     * @param gamma Der winkel vom boden zur unteren Kante.
     * @return The Rectangle from the given values.
     */
    public static Rect valueOf(double x, double y, double w, double gamma) {
        return Rect.valueOf(x, y, w, w, gamma);
    }

    /**
     * Konstruiert ein Rechteck.
     *
     * @param x     Die x Koordinate der unteren linken Ecke.
     * @param y     Die y Koordinate der unteren linken Ecke.
     * @param w     Die Breite des Rechtecks.
     * @param h Die Höhe des Rechtecks.
     * @param gamma Der winkel vom boden zur unteren Kante.
     * @return The Rectangle from the given values.
     */
    public static Rect valueOf(double x, double y, double w, double h, double gamma) {
        var hr = h/w;
        var ang = Math.toRadians(gamma);
        var s = w * Math.sin(ang);
        var c = w * Math.cos(ang);

        var pA = new Vector2(x, y);
        var pB = new Vector2(x + c, y + s);
        var pC = new Vector2(x + c - s*hr, y + s + c*hr);
        var pD = new Vector2(x - s*hr, y + c*hr);
        return new Rect(pA, pB, pC, pD);
    }

    /**
     * Konstruiert ein Rechteck aus 2 Eckpunkten.
     *
     * @param a Der untere Linke Punkt von Rechteck.
     * @param b Der untere Rechte Punkt von Rechteck.
     * @return Ein {@link Rect} aus den 2 Eckpunkten
     */
    public static Rect valueOf(Vector2 a, Vector2 b) {
        var gegenKathete = b.y() - a.y();
        var anKathete = b.x() - a.x();

        var ang = Math.toDegrees(Math.atan2(gegenKathete, anKathete));
        var w = Math.sqrt(gegenKathete * gegenKathete + anKathete * anKathete);

        return Rect.valueOf(a.x(), a.y(), w, ang);
    }

    /**
     * Konstruiert ein Rechteck aus 2 Eckpunkten und einer höhe.
     *
     * @param a      Der untere Linke Punkt von Rechteck.
     * @param b      Der untere Rechte Punkt von Rechteck.
     * @param height Die höhe vom Rechteck.
     * @return Ein {@link Rect} aus den 2 Eckpunkten
     */
    public static Rect valueOf(Vector2 a, Vector2 b, double height) {
        var gegenKathete = b.y() - a.y();
        var anKathete = b.x() - a.x();

        var ang = Math.toDegrees(Math.atan2(gegenKathete, anKathete));
        var w = Math.sqrt(gegenKathete * gegenKathete + anKathete * anKathete);

        return Rect.valueOf(a.x(), a.y(), w, height, ang);
    }

    /**
     * Rechnet die Gegenkathete aus.
     *
     * @return Die Gegenkathete.
     */
    private double getGegenkathete() {
        return this.b.y() - this.a.y();
    }

    /**
     * Rechnet die Ankathete aus.
     *
     * @return Die Ankathete.
     */
    private double getAnkathete() {
        return this.b.x() - this.a.x();
    }

    /**
     * Rechnet die breite und höhe von Rechteck aus.
     *
     * @return Die breite und höhe.
     */
    public double getWidth() {
        var gegenKathete = getGegenkathete();
        var anKathete = getAnkathete();

        return Math.sqrt(gegenKathete * gegenKathete + anKathete * anKathete);
    }

    /**
     * Rechnet den Winkel vom Boden zur unteren Ecke aus.
     *
     * @return Der Winkel vom Boden zue unteren Ecke.
     */
    public double getGamma() {
        var gegenKathete = getGegenkathete();
        var anKathete = getAnkathete();

        return Math.toDegrees(Math.atan2(gegenKathete, anKathete));
    }

    /**
     * Rechnet den Dreieckpunkt E aus.
     *
     * @param delta Den Winkel vom Dreieck.
     * @return Ein {@link Vector2} E für das Dreieck.
     */
    public Vector2 getE(double delta) {
        var del = Math.toRadians(delta);
        var w = getWidth();
        double u = w * Math.cos(del);
        double v = w * Math.sin(del);

        var gamma = Math.toRadians(getGamma());

        return new Vector2(d.x() + u * Math.cos(del + gamma), d.y() + u * Math.sin(del + gamma));
    }

    /**
     * Zeichnet das Rechteck auf dem Bildschirm.
     */
    public void draw() {
        StdDraw.polygon(new double[]{a.x(), b.x(), c.x(), d.x()}, new double[]{a.y(), b.y(), c.y(), d.y()});
    }

    /**
     * Zeichnet die Seiten A-D und B-C
     */
    public void drawSides() {
        StdDraw.line(a.x(), a.y(), d.x(), d.y());
        StdDraw.line(b.x(), b.y(), c.x(), c.y());
    }

    /**
     * Zeichnet die Seiten A-D, A-B, B-C
     */
    public void drawOpenBox() {
        StdDraw.line(a.x(), a.y(), d.x(), d.y());
        StdDraw.line(a.x(), a.y(), b.x(), b.y());
        StdDraw.line(b.x(), b.y(), c.x(), c.y());
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
        a().draw();
        StdDraw.setPenColor(StdDraw.GREEN);
        b().draw();
        StdDraw.setPenColor(StdDraw.RED);
        c().draw();
        StdDraw.setPenColor(StdDraw.MAGENTA);
        d().draw();
        PythagorasBaum.resetDraw();
    }

    /**
     * Gibt den punkt A.
     *
     * @return {@link Vector2} A
     */
    public Vector2 a() {
        return a;
    }

    /**
     * Gibt den punkt B.
     *
     * @return {@link Vector2} B
     */
    public Vector2 b() {
        return b;
    }

    /**
     * Gibt den punkt C.
     *
     * @return {@link Vector2} C
     */
    public Vector2 c() {
        return c;
    }

    /**
     * Gibt den punkt D.
     *
     * @return {@link Vector2} D
     */
    public Vector2 d() {
        return d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Rect) obj;
        return Objects.equals(this.a, that.a) &&
                Objects.equals(this.b, that.b) &&
                Objects.equals(this.c, that.c) &&
                Objects.equals(this.d, that.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "Rect[" +
                "a=" + a + ", " +
                "b=" + b + ", " +
                "c=" + c + ", " +
                "d=" + d + ']';
    }


}
