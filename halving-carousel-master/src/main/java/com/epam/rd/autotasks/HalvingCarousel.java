package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    public CarouselRun run(){
        if (isInRunningState)
        {
            return null;
        }
        isInRunningState = true;
        return new CarouselRunHalving(table, numberOfElements);
    }














}
