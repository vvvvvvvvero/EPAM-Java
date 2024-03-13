package com.epam.rd.autotasks.figures;

class Circle extends Figure
{
    private Point center;
    private double radius;

    public Circle(Point point, double radius)
    {
        if (point != null && radius > 0)
        {
            this.center = point;
            this.radius = radius;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String pointsToString() {
        return center.toString();
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }

    public double getRadius() {
        return radius;
    }
}
