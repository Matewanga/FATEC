package com.nickolss.interfacescomotipos;

public class Point implements Comparable<Point> {
    private int x, y;

    public Point(int x, int y) { this.x = x; this.y = y; }

    @Override
    public String toString() { return "(" + x + ", " + y + ")"; }

    private double distanceToOrigin() { return Math.sqrt(x * x + y * y); }

    @Override
    public int compareTo(Point other) {
        // Ordena pela distância até a origem (0,0)
        return Double.compare(this.distanceToOrigin(), other.distanceToOrigin());
    }
}