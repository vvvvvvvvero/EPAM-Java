package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

class Triangle extends Figure
{
    private Point a;
    private Point b;
    private Point c;

    public Triangle (Point a, Point b, Point c)
    {

        if (a == null || b == null || c == null)
        {
            throw new IllegalArgumentException();
        }
        else if (isCollinear(a, b, c))
        {
            throw new IllegalArgumentException();
        }
        else if (area(a, b, c) == 0)
        {
            throw new IllegalArgumentException();
        }
        else if (isDegenerative(a, b, c))
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }


    @Override
    public Point centroid() {
        double x = (a.getX() + b.getX() + c.getX()) / 3;
        double y = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null )
        {
            throw new IllegalArgumentException();
        }
        else if (!(figure instanceof Triangle))
        {
            throw new IllegalArgumentException();
        }
        Triangle triangle = (Triangle) figure;
        return checkForVertices(triangle);

    }

    private boolean isDegenerative(Point a, Point b, Point c)
    {
        return CalculatingHelper.length(a, b) >= CalculatingHelper.length(b, c) + CalculatingHelper.length(c, a) || CalculatingHelper.length(b, c) >= CalculatingHelper.length(a, b) + CalculatingHelper.length(c, a) || CalculatingHelper.length(c, a) >= CalculatingHelper.length(a, b) + CalculatingHelper.length(b, c);
    }

    private boolean checkForVertices(Triangle triangle)
    {
        if (this.a.equals(triangle.getA()) && this.b.equals(triangle.getB()) && this.c.equals(triangle.getC()))
        {
            return true;
        }
        else if (this.a.equals(triangle.getA()) && this.b.equals(triangle.getC()) && this.c.equals(triangle.getB()))
        {
            return true;
        }
        else if (this.a.equals(triangle.getB()) && this.b.equals(triangle.getA()) && this.c.equals(triangle.getC()))
        {
            return true;
        }
        else if (this.a.equals(triangle.getB()) && this.b.equals(triangle.getC()) && this.c.equals(triangle.getA()))
        {
            return true;
        }
        else if (this.a.equals(triangle.getC()) && this.b.equals(triangle.getA()) && this.c.equals(triangle.getB()))
        {
            return true;
        }
        else if (this.a.equals(triangle.getC()) && this.b.equals(triangle.getB()) && this.c.equals(triangle.getA()))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public double area(Point a, Point b, Point c) {
        double segmentA = CalculatingHelper.length(a, b);
        double segmentB = CalculatingHelper.length(b, c);
        double segmentC = CalculatingHelper.length(c, a);

        double semiPerimeter = (segmentA + segmentB + segmentC) / 2;
        return sqrt(semiPerimeter * (semiPerimeter - segmentA) * (semiPerimeter - segmentB) * (semiPerimeter - segmentC));

    }

    private boolean isCollinear(Point a, Point b, Point c)
    {
        if (a.getX() - b.getX() == 0 && b.getX() - c.getX() == 0 && c.getX() - a.getX() == 0 )
        {
            return true;
        }
        else if (a.getY() - b.getY() == 0 && b.getY() - c.getY() == 0 && c.getY() - a.getY() == 0)
        {
            return true;
        }
        return false;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public double area() {
        double segmentA = CalculatingHelper.length(a, b);
        double segmentB = CalculatingHelper.length(b, c);
        double segmentC = CalculatingHelper.length(c, a);

        double semiPerimeter = (segmentA + segmentB + segmentC) / 2;
        return sqrt(semiPerimeter * (semiPerimeter - segmentA) * (semiPerimeter - segmentB) * (semiPerimeter - segmentC));

    }
}
