package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private final int [] table;
    private int numberOfElements;
    private boolean isInRunningState;
    private final int maxCapacity;


    public DecrementingCarousel(int capacity) {
        this.maxCapacity = capacity;
        table = new int[capacity];
    }

    public boolean addElement(int element){
        if (element <= 0 || isInRunningState || numberOfElements == maxCapacity )
        {
            return false;
        }
        table[numberOfElements++] = element;
        return true;

    }

    public CarouselRun run() {
        if (isInRunningState)
        {
            return null;
        }
        isInRunningState = true;
        return new CarouselRun(table, numberOfElements);
    }

}
