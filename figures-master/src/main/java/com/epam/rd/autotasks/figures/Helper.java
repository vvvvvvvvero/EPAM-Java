package com.epam.rd.autotasks.figures;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class Helper
{
    public static double length(Point p1, Point p2)
    {
        double a = abs(p1.getY() - p2.getY());
        double b = abs(p1.getX() - p2.getX());
        return sqrt(pow(a, 2) + pow(b, 2));
    }

    public static Point leftMost(Point... points)
    {
        double xCoordinateMax = Integer.MAX_VALUE;
        double yCoordinate = 0;

        for (Point point : points)
        {
            if (point.getX() < xCoordinateMax)
            {
                xCoordinateMax = point.getX();
                yCoordinate = point.getY();
            }

        }
        return new Point(xCoordinateMax, yCoordinate);

    }
}
