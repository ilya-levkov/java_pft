package ru.stqa.pft.sandbox;

/**
 * Created by ilya on 21.07.2017.
 */

public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {
        double dx = this.x - p2.x;
        double dy = this.y - p2.y;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}
