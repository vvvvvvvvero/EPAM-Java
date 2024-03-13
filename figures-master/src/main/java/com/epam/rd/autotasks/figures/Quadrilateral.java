package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Quadrilateral extends Figure
{
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d)
    {
        if (a != null && b != null && c != null && d != null)
        {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public double area() {
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, c, d);
        return triangle1.area() + triangle2.area();
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point [] points = new Point[4];
        points[0] = a;
        points[1] = b;
        points[2] = c;
        points[3] = d;
        Point [] copy = Arrays.copyOf(points, points.length);
        return Helper.leftMost(copy);
    }
}
