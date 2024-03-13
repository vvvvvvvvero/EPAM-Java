package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder

        Scanner scanner = new Scanner(System.in);
        int numOfPeople = scanner.nextInt();
        int numOfSlicesPerPizza = scanner.nextInt();
        int i;
        for (i = 0; i < 100; i++)
        {
            if ((i * numOfSlicesPerPizza) % numOfPeople == 0 && i != 0)
            {
                System.out.println(i);
                break;
            }
        }

    }
}
