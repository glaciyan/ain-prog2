package de.ketra.aufgabe5;

import cc.glaciyan.drawing.Point2;
import cc.glaciyan.drawing.Rect;
import edu.princeton.cs.introcs.StdDraw;

public class PythagorasBaum {
    public static void main(String[] args) throws InterruptedException {
//        var size = 40;
//        StdDraw.setXscale(-size, size);
//        StdDraw.setYscale(-1, size * 2);
//        resetDraw();
//        drawTree(10, 45, 12);
        var p = Point2.valueOf("1.4,4");
        System.out.println(p);
    }

    public static void drawTree(double width, double alpha, int depth) {

        var rect = new Rect(0, 0, width, 0);
        rect.draw();
        drawTree(rect, alpha, depth);
    }

    private static void drawTree(Rect root, double alpha, int depth) {
        if (depth == 0) {
            return;
        }

        var left = Rect.valueOf(root.getD(), root.getE(alpha));
        left.draw();
        drawTree(left, alpha, depth - 1);

        var right = Rect.valueOf(root.getE(alpha), root.getC());
        right.draw();
        drawTree(right, alpha, depth - 1);
    }

    public static void resetDraw() {

        StdDraw.setPenRadius(0.004);
        StdDraw.setPenColor(StdDraw.BLACK);
    }

}
