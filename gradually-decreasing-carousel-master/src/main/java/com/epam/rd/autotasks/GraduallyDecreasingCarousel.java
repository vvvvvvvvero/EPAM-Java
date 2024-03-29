package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run(){
        if (isInRunningState)
        {
            return null;
        }
        isInRunningState = true;
        return new CarouselRunGradually(table, numberOfElements);
    }
}
