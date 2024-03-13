package com.epam.rd.autotasks;

public class CarouselRunWithLimit extends CarouselRun
{
    private int limitCounter;

    public CarouselRunWithLimit(int[] table, int elements, int limitCounter) {
        super(table, elements);
        this.limitCounter = limitCounter;
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
            while((current = table[pointer++ % table.length]) == 0){}
            if(current == 1){
                elements--;
            }
            limitCounter--;
            return table[(pointer - 1) % table.length]--;
        }


    }

    @Override
    public boolean isFinished() {
        return elements == 0 || limitCounter == 0;
    }
}
