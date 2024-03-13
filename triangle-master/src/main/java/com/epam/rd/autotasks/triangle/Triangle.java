package com.epam.rd.autotasks.triangle;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c)
    {
        if (a == null || b == null || c == null)
        {
            throw new IllegalArgumentException();
        }

        else if (length(a, b) >= length(b, c) + length(c, a) || length(b, c) >= length(a, b) + length(c, a) || length(c, a) >= length(a, b) + length(b, c))
        {
            throw new IllegalArgumentException();
        }

            this.a = a;
            this.b = b;
            this.c = c;

    }

    public double area()
    {
        double semiperimeter = (calculateSegmentA() + calculateSegmentB() + calculateSegmentC()) / 2;

        return sqrt(semiperimeter * (semiperimeter - calculateSegmentA()) * (semiperimeter - calculateSegmentB()) * (semiperimeter - calculateSegmentC()));

    }

    public Point centroid()
    {
        double x = (a.getX() + b.getX() + c.getX()) / 3;
        double y = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(x, y);

    }

    private double length(Point p1, Point p2) //length between two points
    {
        double a = abs(p1.getY() - p2.getY());
        double b = abs(p1.getX() - p2.getX());
        return sqrt(pow(a, 2) + pow(b, 2));
    }


    private double calculateSegmentA()
    {
        return length(a, b);
    }

    private double calculateSegmentB()
    {
        return length(b, c);
    }

    private double calculateSegmentC()
    {
        return length(c, a);
    }



}
