package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int number;
        while ((number = scanner.nextInt()) != 0)
        {
            if (number > max)
            {
                max = number;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(max());
    }
}
