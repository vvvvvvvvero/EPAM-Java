package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    protected int actionLimit;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }

    public CarouselRun run(){
        if (isInRunningState)
        {
            return null;
        }
        isInRunningState = true;
        return new CarouselRunWithLimit(table, numberOfElements, actionLimit);
    }
}
