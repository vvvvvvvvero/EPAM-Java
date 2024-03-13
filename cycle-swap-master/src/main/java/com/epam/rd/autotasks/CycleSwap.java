package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length == 0)
        {
            System.out.println("The input Array is Empty");;
        }
        else
        {
            int lastElem = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = lastElem;

        }

    }

    static void cycleSwap(int[] array, int shift)
    {
        if (array.length == 0)
        {
            System.out.println("The input Array is Empty");;
        }
        else
        {
            int [] savedValues = Arrays.copyOf(array, array.length);;
            System.arraycopy(array, array.length - shift, savedValues, 0, shift);
            System.arraycopy(array, 0, array, shift, array.length - shift);
            System.arraycopy(savedValues, 0, array, 0, shift);

        }


    }
}
