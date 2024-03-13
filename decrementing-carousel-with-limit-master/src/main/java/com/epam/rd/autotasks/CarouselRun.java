package com.epam.rd.autotasks;

import java.util.Arrays;

public class CarouselRun {

    protected int [] table;
    protected int elements;
    protected int pointer;

    public CarouselRun(int[] table, int elements) {
        this.table = Arrays.copyOf(table, elements);
        this.elements = elements;
    }

    public int next() {
        if (isFinished())
        {
            return -1;
        }
        else
        {
            int current;
            while((current = table[pointer++ % table.length]) == 0){}
            if(current == 1){
                elements--;
            }
            return table[(pointer - 1) % table.length]--;
        }


    }


    public boolean isFinished() {
        return elements == 0;
    }

}
