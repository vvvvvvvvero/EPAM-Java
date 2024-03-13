package com.epam.rd.autotasks.figures;



abstract class Figure{

    public abstract double area();

    public abstract String pointsToString();

    public String toString() {
        if (this instanceof Circle)
        {
            return this.getClass().getSimpleName() + "[" + pointsToString() + ((Circle) this).getRadius() + "]";
        }
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public abstract Point leftmostPoint();

}
