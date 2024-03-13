package com.epam.rd.autotasks.figures;

import java.util.Arrays;

import static java.lang.Math.sqrt;

class Triangle extends Figure {
    private Point a;
    private Point b;
    private Point c;

    public Triangle (Point a, Point b, Point c)
    {
        if (a != null && b != null && c != null)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else
        {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public double area() {
        double segmentA = Helper.length(a, b);
        double segmentB = Helper.length(b, c);
        double segmentC = Helper.length(c, a);

        double semiPerimeter = (segmentA + segmentB + segmentC) / 2;
        return sqrt(semiPerimeter * (semiPerimeter - segmentA) * (semiPerimeter - segmentB) * (semiPerimeter - segmentC));

    }

    @Override
    public String pointsToString() {

        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point [] points = new Point[3];
        points[0] = a;
        points[1] = b;
        points[2] = c;
        Point [] copy = Arrays.copyOf(points, points.length);
        return Helper.leftMost(copy);

    }

}
