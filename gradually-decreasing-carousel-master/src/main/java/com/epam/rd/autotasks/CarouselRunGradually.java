package com.epam.rd.autotasks;


import java.util.Arrays;

public class CarouselRunGradually extends CarouselRun
{
    private int [] decrement;

    public CarouselRunGradually(int[] table, int elements) {
        super(table, elements);
        decrement = new int[table.length];
        Arrays.fill(decrement, 1);
    }

    @Override
    public int next() {
        if (isFinished())
        {
            return -1;
        }
        else
        {
            int current;
            while((current = table[pointer++ % table.length]) <= 0){}

            int index = (pointer - 1) % table.length;
            int elementToReturn = table[(pointer - 1) % table.length];
            table[index] -= decrement[index];
            decrement[index]++;

            if(table[index] <= 0){
                elements--;
            }
            return elementToReturn;

        }
    }
}
