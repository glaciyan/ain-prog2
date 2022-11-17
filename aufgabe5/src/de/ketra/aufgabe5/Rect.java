package de.ketra.aufgabe5;

import edu.princeton.cs.introcs.StdDraw;

public class Rect {
    Point a; // 1. ecke
    Point b; // 2.
    Point c; // 3.
    Point d; // 4.

    public Rect(double x, double y, double w, double gamma) {
        double ang = Math.toRadians(gamma);
        double s = w * Math.sin(ang);
        double c = w * Math.cos(ang);

        this.a = new Point(x, y);
        this.b = new Point(x + c, y + s);
        this.c = new Point(x + c - s, y + s + c);
        this.d = new Point(x - s, y + c);
    }

    public static Rect valueOf(Point a, Point b) {
        double gegenKathete = b.getY() - a.getY();
        double anKathete = b.getX() - a.getX();

        double ang = Math.toDegrees(Math.atan2(gegenKathete, anKathete));
        double w = Math.sqrt(gegenKathete * gegenKathete + anKathete * anKathete);

        return new Rect(a.getX(), a.getY(), w, ang);
    }

    public static Rect valueOf(double x1, double y1, double x2, double y2) {
        return Rect.valueOf(new Point(x1, y1), new Point(x2, y2));
    }

    private double getGegenKathete() {
        return this.b.getY() - this.a.getY();
    }

    private double getAnKathete() {
        return this.b.getX() - this.a.getX();
    }

    public double getWidth() {
        double gegenKathete = getGegenKathete();
        double anKathete = getAnKathete();

        return Math.sqrt(gegenKathete * gegenKathete + anKathete * anKathete);
    }

    public double getGamma() {
        double gegenKathete = getGegenKathete();
        double anKathete = getAnKathete();

        return Math.toDegrees(Math.atan2(gegenKathete, anKathete));
    }

    public Point getE(double delta) {
        var del = Math.toRadians(delta);
        var w = getWidth();
        double u = w * Math.cos(del);
        double v = w * Math.sin(del);

        var gamma = Math.toRadians(getGamma());

        return new Point(d.getX() + u * Math.cos(del + gamma), d.getY() + u * Math.sin(del + gamma));
    }

    public void draw() {
        StdDraw.polygon(new double[]{a.getX(), b.getX(), c.getX(), d.getX()}, new double[]{a.getY(), b.getY(), c.getY(), d.getY()});
    }

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

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

}
