package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        if (seconds < 60)
        {
            System.out.printf("%01d:%02d:%02d%n", 0, 0, seconds);
        }
        else if (seconds < 3600)
        {
            System.out.printf("%01d:%02d:%02d%n", 0, seconds / 60, seconds % 60);
        }
        else if (seconds < 86400)
        {
            System.out.printf("%01d:%02d:%02d%n", seconds/3600, (seconds % 3600) / 60, (seconds % 3600) % 60);
        }
        else
        {
            System.out.printf("%01d:%02d:%02d%n", 0, (seconds % 3600) / 60, (seconds % 3600) % 60);
        }



    }
}
