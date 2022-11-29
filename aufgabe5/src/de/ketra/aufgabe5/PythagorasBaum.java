package de.ketra.aufgabe5;

import cc.glaciyan.drawing.Rect;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.Random;

public class PythagorasBaum {
    private final static double MIN_ALPHA = 25;
    private final static double MAX_ALPHA = 45;

    private final static double MIN_HEIGHT = 3;
    private final static double MAX_HEIGHT = 12;

    private final static double LEAF_THRESHOLD = 2;

    public static void main(String[] args) {
//        StdDraw.show(0);
        StdDraw.setCanvasSize(800, 800);

        var scale = 70;
        StdDraw.setXscale(-scale, scale);
        StdDraw.setYscale(-1, scale * 2);
        resetDraw();
        drawTree(10, 30, 12);
//        drawRandomTree(6, 60, 12);
        StdDraw.show(0);
    }

    private static void drawRandomTree(double rootWidth, int depth) {
        var root = Rect.valueOf(0, 0, rootWidth, 0);
        root.drawOpenBox();
        drawRandomTree(root, depth);
    }

    private static void drawRandomTree(double rootWidth, double rootHeight, int depth) {
        var root = Rect.valueOf(0, 0, rootWidth, rootHeight, 0);
        root.drawOpenBox();
        drawRandomTree(root, depth);
    }

    private static void drawRandomTree(Rect root, int depth) {
        if (depth == 0) {
            return;
        }

        var random = new Random();
        var alpha = random.nextDouble(MIN_ALPHA, MAX_ALPHA);

        var left = Rect.valueOf(root.d(), root.getE(alpha), random.nextDouble(MIN_HEIGHT, MAX_HEIGHT) * (0.1 * depth));
        if (left.getWidth() < LEAF_THRESHOLD) StdDraw.setPenColor(StdDraw.GREEN);
        left.drawSides();
        resetDraw();
        drawRandomTree(left, depth - 1);

        var right = Rect.valueOf(root.getE(alpha), root.c(), random.nextDouble(MIN_HEIGHT, MAX_HEIGHT) * (0.1 * depth));
        if (left.getWidth() < LEAF_THRESHOLD) StdDraw.setPenColor(StdDraw.GREEN);
        right.drawSides();
        resetDraw();
        drawRandomTree(right, depth - 1);
    }

    public static void drawTree(double rootWidth, double alpha, int depth) {
        var root = Rect.valueOf(0, 0, rootWidth, 0);
        root.drawOpenBox();
        drawTree(root, alpha, depth);
    }

    private static void drawTree(Rect root, double alpha, int depth) {
        if (depth == 0) {
            return;
        }

        var left = Rect.valueOf(root.d(), root.getE(alpha));
        if (left.getWidth() < LEAF_THRESHOLD) StdDraw.setPenColor(StdDraw.GREEN);
        left.draw();
        resetDraw();
        drawTree(left, alpha, depth - 1);

        var right = Rect.valueOf(root.getE(alpha), root.c());
        if (left.getWidth() < LEAF_THRESHOLD) StdDraw.setPenColor(StdDraw.GREEN);
        right.draw();
        resetDraw();
        drawTree(right, alpha, depth - 1);
    }

    public static void resetDraw() {

        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(Color.getHSBColor(60, 0.67f, 0.39f));
    }

}
