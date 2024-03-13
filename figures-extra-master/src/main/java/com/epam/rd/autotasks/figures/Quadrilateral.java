package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure
{
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d)
    {
        if (a == null || b == null || c == null || d == null)
        {
            throw new IllegalArgumentException();
        }
        else if (isCollinear(a, b, c, d))
        {
            throw new IllegalArgumentException();
        }
        else if (area(a, b, c, d) == 0)
        {
            throw new IllegalArgumentException();
        }
        else if (!isConvex(a, b, c, d))
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }


    @Override
    public Point centroid() {
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, c, d);

        Point p1 = triangle1.centroid();
        Point p2 = triangle2.centroid();

        double x;
        double y;
        x = (p1.getX() + p2.getX()) / 2;
        y = (p1.getY() + p2.getY()) / 2;
        return new Point(x, y);


    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null )
        {
            throw new IllegalArgumentException();
        }
        else if (!(figure instanceof Quadrilateral))
        {
            throw new IllegalArgumentException();
        }
        Quadrilateral quadrilateral = (Quadrilateral) figure;
        return checkForVertices(quadrilateral);

    }

    private boolean isConvex(Point a, Point b, Point c, Point d)
    {
        double angle1 = CalculatingHelper.calculateAngle(a, b);
        double angle2 = CalculatingHelper.calculateAngle(b, c);
        double angle3 = CalculatingHelper.calculateAngle(c, d);
        double angle4 = CalculatingHelper.calculateAngle(d, a);
        double sum = angle1 + angle2 + angle3 + angle4;
        return sum < Math.toDegrees(Math.PI);



    }

    public double area(Point a, Point b, Point c, Point d) {
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, c, d);
        return triangle1.area() + triangle2.area();
    }

    private boolean isCollinear(Point a, Point b, Point c, Point d)
    {
        if (a.getX() - b.getX() == 0 && b.getX() - c.getX() == 0 && c.getX() - d.getX() == 0)
        {
            return true;
        }
        else if (a.getY() - b.getY() == 0 && b.getY() - c.getY() == 0 && c.getY() - d.getY() == 0)
        {
            return true;
        }
        return false;
    }

    private boolean checkForVertices(Quadrilateral quadrilateral)
    {
        if (this.a.equals(quadrilateral.getA()) && this.b.equals(quadrilateral.getB()) && this.c.equals(quadrilateral.getC()))
        {
            return true;
        }
        else if (this.a.equals(quadrilateral.getA()) && this.b.equals(quadrilateral.getC()) && this.c.equals(quadrilateral.getB()))
        {
            return true;
        }
        else if (this.a.equals(quadrilateral.getB()) && this.b.equals(quadrilateral.getA()) && this.c.equals(quadrilateral.getC()))
        {
            return true;
        }
        else if (this.a.equals(quadrilateral.getB()) && this.b.equals(quadrilateral.getC()) && this.c.equals(quadrilateral.getA()))
        {
            return true;
        }
        else if (this.a.equals(quadrilateral.getC()) && this.b.equals(quadrilateral.getA()) && this.c.equals(quadrilateral.getB()))
        {
            return true;
        }
        else if (this.a.equals(quadrilateral.getC()) && this.b.equals(quadrilateral.getB()) && this.c.equals(quadrilateral.getA()))
        {
            return true;
        }
        else
        {
            return false;
        }

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

    public Point getD() {
        return d;
    }
}
