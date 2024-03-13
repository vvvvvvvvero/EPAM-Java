package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array)
    {
        int localMaxes = 0;
        boolean[] localMaxArr = new boolean[array.length];

        for(int i =0;i<array.length;i++){
            if(i == 0){
                if(array[0] > array[1]){
                    localMaxes++;
                    localMaxArr[i] = true;
                }
            }else if(i == array.length - 1) {
                if (array[i] > array[i - 1]) {
                    localMaxes++;
                    localMaxArr[i] = true;
                }
            }else{
                if(array[i] > array[i-1] && array[i] > array[i+1]){
                    localMaxes++;
                    localMaxArr[i] = true;
                }
            }
        }

        int[] newArr = new int[array.length - localMaxes];
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if(localMaxArr[i] == false){
                newArr[index++] = array[i];
            }
        }
        return newArr;

    }
}
