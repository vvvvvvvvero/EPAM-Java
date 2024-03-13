package com.epam.rd.autotasks.figures;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class CalculatingHelper
{
    public static double length(Point p1, Point p2)
    {
        double a = abs(p1.getY() - p2.getY());
        double b = abs(p1.getX() - p2.getX());
        return sqrt(pow(a, 2) + pow(b, 2));
    }

    public static double calculateAngle(Point p1, Point p2) {
        double xDiff = p2.getX() - p1.getX();
        double yDiff = p2.getY() - p1.getY();
        return Math.toDegrees(Math.atan2(yDiff, xDiff));
    }

}
