package com.nickolss.exemplocomparable;

public class Point implements Comparable<Point> {
    private static final Point ORIGIN = new Point();
    private int x, y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        int xdiff = x - p.x;
        int ydiff = y - p.y;
        return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
    }

    @Override
    public int compareTo(Point p) {
        double pDist = p.distance(ORIGIN);
        double dist  = this.distance(ORIGIN);

        if (dist > pDist) return 1;
        else if (dist == pDist) return 0;
        else return -1;
    }
}

