package com.epam.rd.autotasks;

public class CarouselRunHalving extends CarouselRun
{

    public CarouselRunHalving(int[] table, int elements) {
        super(table, elements);
    }

    @Override
    public int next() {
        if (isFinished())
        {
            return -1;
        }
        else {
            int current;
            while ((current = table[pointer++ % table.length]) == 0) {
            }
            if (current == 1) {
                elements--;
            }

            int returnVal = table[(pointer - 1) % table.length];
            table[(pointer - 1) % table.length] = table[(pointer - 1) % table.length] / 2;
            return returnVal;
        }
    }
}
