package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){
        boolean [] check = new boolean[array.length];
        check[0] = false;
        check[1] = false;
        for (int i = 2; i < array.length; i++)
        {
            if (array[i - 1] + array[i - 2] == array[i])
            {
                check[i] = true;
            }
            else {
                check[i] = false;
            }
        }
        return check;
    }
}
