package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree

        Scanner scanner = new Scanner(System.in);
        int stepsUp = scanner.nextInt();
        int stepsDown = scanner.nextInt();
        int height = scanner.nextInt();
        int counter = 0;
        int pos = 0;

        if (stepsUp <= stepsDown && stepsUp < height)
        {
            System.out.println("Impossible");
        }
        else {
            while (pos < height)
            {
                ++counter;
                pos = pos + stepsUp;
                if (pos >= height)
                {
                    System.out.println(counter);
                    break;
                }
                pos = pos - stepsDown;
            }

        }

    }
}
