package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".

        Scanner scanner = new Scanner(System.in);
        int numberOfStrangers = scanner.nextInt();

        if (numberOfStrangers == 0)
        {
            System.out.println("Oh, it looks like there is no one here");
        }
        else if (numberOfStrangers < 0)
        {
            System.out.println("Seriously? Why so negative?");
        }
        else
        {
            Scanner scanner1 = new Scanner(System.in);
            String [] names = new String[numberOfStrangers];
            for (int i = 0; i < names.length; i++)
            {
                String name = scanner1.nextLine();
                names[i] = name;
            }

            for (int i = 0; i < names.length; i++)
            {
                System.out.println("Hello, " + names[i]);
            }

        }
    }
}
