package com.epam.rd.autotasks.godutch;

import java.util.Scanner;
import java.util.Set;

public class GoDutch {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int bill = scanner.nextInt();
        int amountOfPeople = scanner.nextInt();
        if (bill < 0)
        {
            System.out.println("Bill total amount cannot be negative");
        }
        else if (amountOfPeople <= 0)
        {
            System.out.println("Number of friends cannot be negative or zero");
        }
        else {
            int totalBill = bill + bill / 10;
            System.out.println(totalBill / amountOfPeople);
        }

    }
}
