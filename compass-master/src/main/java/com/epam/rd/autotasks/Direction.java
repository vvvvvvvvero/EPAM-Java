package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }


    private int degrees;

    public static Direction ofDegrees(int degrees) {
        if (degrees % 45 != 0){
            return null;
        }
        Direction [] directions = Direction.values();
        for (int i = 0; i < directions.length; i++)
        {
            if (degrees == directions[i].degrees)
            {
                return directions[i];
            }
            else if (degrees >= 360)
            {
                return directions[degrees/360 -1];
            }
            else if (degrees < 0)
            {
                return directions[(360 + degrees) / 45];
            }

        }
        return null;

    }

    public static Direction closestToDegrees(int degrees) {

        degrees = degrees % 360;
        if(degrees < 0) degrees = 360 + degrees;

        int minDistance = Integer.MAX_VALUE;
        Direction minDistanceDir = null;

        int delta;
        for(Direction d: values()){
            if((delta = Math.abs(degrees - d.degrees)) < minDistance){
                minDistance = delta;
                minDistanceDir = d;
            }
        }
        return minDistanceDir;
    }

    public Direction opposite() {
        if (this == N) {
            return S;
        }
        else if (this == NE) {
           return SW;
        }
        else if (this == E) {
            return W;
        }
        else if (this == SE) {
            return NW;
        }
        else if (this == S) {
            return N;
        }
        else if (this == SW) {
            return NE;
        }
        else if (this == W) {
            return E;
        }
        else if (this == NW) {
            return SE;
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {

        int dist = Math.abs(direction.degrees - degrees);
        if(dist > 180 ){
            dist = 360 - dist;
        }
        return dist;
    }
}
