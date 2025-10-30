package com.nickolss.exemplocomparable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Point> pontos = new ArrayList<>();
        pontos.add(new Point(3, 4));  // distância 5 da origem
        pontos.add(new Point(1, 1));  // distância ~1.41 da origem
        pontos.add(new Point(0, 5));  // distância 5 da origem

        Collections.sort(pontos); // usa compareTo para ordenar

        for (Point p : pontos) {
            System.out.println(p); // usa toString() -> (x, y)
        }
    }
}
