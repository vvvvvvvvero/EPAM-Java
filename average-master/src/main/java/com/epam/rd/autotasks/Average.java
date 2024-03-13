package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int number;
        int sum = 0;
        int counter = 0;
        while ((number = scanner.nextInt()) != 0)
        {
           sum += number;
           counter++;
        }
        System.out.println(sum/counter);

    }

}