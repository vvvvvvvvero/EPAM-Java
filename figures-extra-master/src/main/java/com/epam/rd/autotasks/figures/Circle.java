package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Circle extends Figure
{
    private Point center;
    private double radius;

    public Circle(Point point, double radius)
    {
        if (point == null)
        {
            throw new IllegalArgumentException();
        }
        else if (isRadiusLessOrZero(radius) || area(radius) == 0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.center = point;
            this.radius = radius;
        }
    }



    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null)
        {
            throw new IllegalArgumentException();
        }
        if (!(figure instanceof Circle))
        {
            throw new IllegalArgumentException();
        }
        Circle circle = (Circle) figure;
        return this.equals(circle) || this.radius == circle.getRadius();
    }

    private boolean isRadiusLessOrZero(double radius)
    {
        return radius <= 0;
    }

    public double area(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
