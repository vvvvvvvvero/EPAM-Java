package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY())
        {
            throw new IllegalArgumentException();
        }

        this.start = start;
        this.end = end;

    }

    double length() {
        double a = abs(start.getY() - end.getY());
        double b = abs(start.getX() - end.getX());
        return sqrt(pow(a, 2) + pow(b, 2));

    }

    Point middle() {
        double x;
        double y;
        x = (start.getX() + end.getX()) / 2;
        y = (start.getY() + end.getY()) / 2;
        return new Point(x, y);
    }

    Point intersection(Segment another) {
        double ua;
        double ub;
        double denominator = (another.end.getY() - another.start.getY()) * (this.end.getX() - this.start.getX()) - (another.end.getX() - another.start.getX()) * (this.end.getY() - this.start.getY());
        if (denominator == 0) {
            return null;
        }
        ua = ((another.end.getX() - another.start.getX()) * (this.start.getY() - another.start.getY()) - (another.end.getY() - another.start.getY()) * (this.start.getX() - another.start.getX())) / denominator;
        ub = ((this.end.getX() - this.start.getX()) * (this.start.getY() - another.start.getY()) - (this.end.getY() - this.start.getY()) * (this.start.getX() - another.start.getX())) / denominator;

        if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f)
        {
            return new Point(this.start.getX() + ua * (this.end.getX() - this.start.getX()), this.start.getY() + ua * (this.end.getY() - this.start.getY()));
        }
        return null;
    }

}
