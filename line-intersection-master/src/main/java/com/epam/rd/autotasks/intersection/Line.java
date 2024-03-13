package com.epam.rd.autotasks.intersection;

public class Line {

    private int k;
    private int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        int x;
        int y;
        if (this.k == other.k)
        {
            return null;
        }
        else
        {
            x = (other.b - this.b)/(this.k - other.k);
            y = this.k * x + this.b;
        }
        return new Point(x, y);
    }

}
